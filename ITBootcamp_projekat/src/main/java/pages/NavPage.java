package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavPage {
    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLanguageButton() {
        return this.driver.findElement(By.className("btnLocaleActivation"));
    }

    public WebElement getLanguageButtonEN() {
        return this.driver.findElement(By.className("btnEN"));
    }

    public WebElement getLanguageButtonES() {
        return this.driver.findElement(By.className("btnES"));
    }

    public WebElement getLanguageButtonFR() {
        return this.driver.findElement(By.className("btnFR"));
    }

    public WebElement getLanguageButtonCN() {
        return this.driver.findElement(By.className("btnCN"));
    }

    public WebElement getLoginButton() {
        return this.driver.findElement(By.linkText("LOGIN"));
    }

    public WebElement getLogoutButton() {
        return this.driver.findElement(By.className("btnLogout"));
    }

    public WebElement getSignupButton() {
        return this.driver.findElement(By.linkText("SIGN UP"));
    }

    public WebElement getAdminButton() {
        return this.driver.findElement(By.className("btnAdmin"));
    }

    public WebElement getCitiesButton() {
        return this.driver.findElement(By.linkText("Cities"));
    }

    public void goToHomeUrl() {
        this.driver.navigate().to(driver.getCurrentUrl() + "home");
    }

    public void waitForLoginPageToLoadUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/login"));
    }

    public void goToProfileUrl() {
        this.driver.get(driver.getCurrentUrl() + "profile");
    }

    public void goToAdminCitiesUrl() {
        this.driver.get(driver.getCurrentUrl() + "admin/cities");
    }

    public void goToAdminUsersUrl() {
        this.driver.get(driver.getCurrentUrl() + "admin/users");
    }

    public WebElement getPageHeader() {
        return this.driver.findElement(By.tagName("h1"));
    }

}