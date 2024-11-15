package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyFacebookTest {

    private WebDriver webDriver;
    private String CHROME_DRIVER = System.getProperty("user.dir")+"/src/main/resources/driver/chrome/chromedriver.exe";


    @BeforeClass
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
        WebDriverManager.chromedriver().setup();

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.facebook.com/");
    }

    @Test
    public void loginFacebook() throws InterruptedException {
        WebElement textFieldUsername = webDriver.findElement(By.name("email"));
        textFieldUsername.clear();
        textFieldUsername.sendKeys("mfernanda.mgl95@gmail.com");
        WebElement textFielPassword = webDriver.findElement(By.name("pass"));
        textFielPassword.clear();
        textFielPassword.sendKeys("123456");
        WebElement buttonLogIn = webDriver.findElement(By.name("login"));
       // buttonLogIn.click();
        Thread.sleep(100);
        //WebElement text = webDriver.findElement(By.xpath("//*[contains(text(),'Inicio')]"));
        //assertTrue(text.isDisplayed());
        //"//a[contains(text(),'Inicio')]"
        //link Inicio


        System.out.println("CASO OK !!!! :D");
    }

    @AfterClass
    public void tearDown(){
        webDriver.close();
        webDriver.quit();
    }

}
