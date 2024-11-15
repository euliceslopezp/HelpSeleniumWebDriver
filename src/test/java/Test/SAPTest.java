package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SAPTest {

    private WebDriver driver;
    private String CHROME_DRIVER = System.getProperty("user.dir") + "/src/main/resources/driver/chrome/chromedriver.exe";

    @BeforeClass
    public void setUp() {
        //System.setProperty("driver.chrome.driver", CHROME_DRIVER);

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");

      driver = new ChromeDriver(options);

       // WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://vhbaps4dci.hec.dev.lima.bcp.com.pe:44300/sap/bc/ui2/flp?_sap-hash=JTIzU2hlbGwtaG9tZQ#Shell-home");
    }

    @Test
    public void testFormulario() throws InterruptedException {

        WebElement user = driver.findElement(By.id("USERNAME_FIELD-inner"));
        user.sendKeys("EulICES");

        Thread.sleep(6000);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
