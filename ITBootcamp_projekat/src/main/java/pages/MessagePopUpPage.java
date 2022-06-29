package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage {
    private WebDriver driver;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForMessagePopUpToBeShown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Close')]")));
    }

    public WebElement loginAndSignupErrorMessages() {
        return this.driver.findElement(By.tagName("li"));
    }

    public void waitSignupVerifyYourAccountDialog() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("btnClose")));
    }

    public WebElement getVerifyYourAccountCloseButton() {
        return this.driver.findElement(By.className("btnClose"));

    }

    public WebElement getVerifyYourAccountDialogMessage() {
        return this.driver.findElement(By.className("v-card__title"));
    }


}