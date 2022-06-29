package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {
    private WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNameInputField() {
        return this.driver.findElement(By.id("name"));
    }

    public WebElement getEmailInputField() {
        return this.driver.findElement(By.id("email"));
    }

    public WebElement getPasswordInputField() {
        return this.driver.findElement(By.id("password"));
    }

    public WebElement getConfirmPasswordInputField() {
        return this.driver.findElement(By.id("confirmPassword"));
    }

    public WebElement getSignMeUpButton() {
        return this.driver.findElement(By.className("v-btn--contained"));
    }
}