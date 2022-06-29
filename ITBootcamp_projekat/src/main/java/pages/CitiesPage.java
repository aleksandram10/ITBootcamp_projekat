package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {
    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton() {
        return this.driver.findElement(By.className("btnNewItem"));
    }

    public WebElement getNameInputField() {
        return this.driver.findElement(By.id("name"));
    }

    public void waitForDialogueToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-card")));
    }

    public WebElement getSaveButton() {
        return this.driver.findElement(By.className("btnSave"));
    }

    public void waitSuccessfullyMessageToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
    }

    public WebElement getMessageSuccessfullyText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
        return this.driver.findElement(By.className("success"));
    }

    public WebElement getSearchInputField() {
        return this.driver.findElement(By.id("search"));
    }

    public void waitForRowsToAppear(int rowNum) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), rowNum + 1));
    }

    public WebElement getEditButton(int rowIndex) {
        return this.driver.findElements(By.id("edit")).get(rowIndex - 1);
    }

    public void waitForSaveButtonToBeClicable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(getSaveButton()));
    }

    public WebElement getTableCell(int rowIndex, int columnIndex) {
        return this.driver.findElement(By.xpath("//tbody/tr[" + rowIndex + "]/td[" + columnIndex + "]"));
    }

    public WebElement getDeleteButtonFromRow(int rowIndex) {
        return this.driver.findElements(By.id("delete")).get(rowIndex - 1);
    }

    public WebElement getDeleteButtonFromDialogue() {
        return this.driver.findElement(By.xpath("//div[contains(@class,'v-card__actions')]/button[2]"));
    }

}