package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AppBCPTest {


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
        driver.get("https://qa.bcp.n5platform.com/login");
    }

    @Test
    public void testFormulario() throws InterruptedException {
        Thread.sleep(3000);

        WebElement user1 = driver.findElement(By.cssSelector("input[type='text']"));;
        user1.sendKeys("judithcastillo");

        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));;
        password .sendKeys("T34365$88");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btnacceder = driver.findElement(By.cssSelector("button[type='submit']"));;
       // btnacceder.click();
        wait.until(ExpectedConditions.elementToBeClickable(btnacceder)).click();

        Thread.sleep(500);
        WebElement btnfavoritos = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/aside/nav/div[1]"));;
        wait.until(ExpectedConditions.elementToBeClickable(btnfavoritos)).click();


        Thread.sleep(15000);

        // Supongamos que tienes dos pestañas abiertas
Set<String> windowHandles = driver.getWindowHandles();
List<String> tabs = new ArrayList<>(windowHandles);
driver.switchTo().window(tabs.get(1));



        WebElement lbldescripcion = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@N5/N5-AIM\"]/div/div[1]/div/div[1]/div[2]/div[1]/span"));;
       String nombre =  lbldescripcion.getText();
        System.out.println("dsdsds:  "+nombre);






    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
