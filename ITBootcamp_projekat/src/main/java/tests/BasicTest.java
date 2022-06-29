package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;


public class BasicTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected CitiesPage citiesPage;
    protected NavPage navPage;
    protected SignupPage signupPage;
    protected MessagePopUpPage messagePopUpPage;

    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        loginPage = new LoginPage(driver);
        citiesPage = new CitiesPage(driver);
        navPage = new NavPage(driver);
        signupPage = new SignupPage(driver);
        messagePopUpPage = new MessagePopUpPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to(baseUrl);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}