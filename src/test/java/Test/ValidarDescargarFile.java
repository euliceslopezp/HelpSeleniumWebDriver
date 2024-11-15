package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.*;
import java.util.logging.Logger;

public class ValidarDescargarFile {

    private static WebDriver driver;
    private final  Logger LOG = Logger.getLogger(this.getClass().getName());
    private String CHROME_DRIVER = System.getProperty("user.dir") + "/src/main/resources/driver/chrome/chromedriver.exe";

    private static String downloadFilepath = "C:\\Users\\eloppint\\Downloads\\DesElpin";

   @BeforeAll
    public static  void setUp() {
        WebDriverManager.chromedriver().setup();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", downloadFilepath);

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--ignore-certificate-errors");
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/download");


    }

@Test
    public void testDescarga() throws InterruptedException {

    try {
        File dir = new File(downloadFilepath);
        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (!file.delete()) {
                        LOG.severe("No se ha podido eliminar el archivo: " + file.getName());
                    }
                }
            }
        } else {
            if (!dir.mkdirs()) {
                LOG.severe("No se ha podido crear el directorio: " + dir.getName());
            }
        }

        WebElement descargar = driver.findElement(By.xpath("//a[contains(text(),'test.txt')]"));
        descargar.click();
        Thread.sleep(5000);

            File[] dirContents = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

            if (dirContents != null && dirContents.length > 0) {
                LOG.info("El archivo se ha descargado correctamente.");

            } else {
                LOG.severe("La descarga del archivo ha fallado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
}
