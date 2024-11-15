package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestFormulario {
    private WebDriver driver;
    private String CHROME_DRIVER = System.getProperty("user.dir") + "/src/main/resources/driver/chrome/chromedriver.exe";

    @BeforeClass
    public void setUp() {
        //System.setProperty("driver.chrome.driver", CHROME_DRIVER);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/form");
    }

    @Test
    public void testLista() throws InterruptedException {

        WebElement dropDownMenu = driver.findElement(By.id("dropdownMenuButton"));
        dropDownMenu.click();

        WebElement autoCompleteItem = driver.findElement(By.id("autocomplete"));
        autoCompleteItem.click();


    }

    @Test
    public void testFormulario() throws InterruptedException {
//        WebElement firstName = driver.findElement(By.id("first-name"));
//        firstName.sendKeys("Miguel");
//
//        WebElement lastName = driver.findElement(By.id("last-name"));
//        lastName.sendKeys("Gonzalez");
//
//        WebElement jobTitle = driver.findElement(By.id("job-title"));
//        jobTitle.sendKeys("QA Engineer");
//
//        WebElement education = driver.findElement(By.id("radio-button-2"));
//        education.click();
//
//        WebElement  sex = driver.findElement(By.id("checkbox - 1"));
//        sex.click();

 driver.findElement(By.id("select-menu")).sendKeys("2");

Thread.sleep(500);
//        WebElement date = driver.findElement(By.id("datepicker"));
//        date.sendKeys("05/28/2021");

    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }


}
