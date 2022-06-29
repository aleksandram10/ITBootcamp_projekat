package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class AdminCitiesTests extends BasicTest {

    @Test(priority = 10)
    public void visitAdminPanelAndListCities() {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.getLoginButton().click();
        loginPage.getEmailInputField().sendKeys(email);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "Current site path do not contains /admin/cities in URL");
    }

    @Test(priority = 20)
    public void verifyInputTypes() {
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForDialogueToBeVisible();
        Assert.assertEquals(citiesPage.getNameInputField().getAttribute("type"), "text",
                "Name input field attribute type is not text");
    }

    @Test(priority = 30)
    public void createNewCity() {
        String city = "Aleksandra Markovic's city";

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForDialogueToBeVisible();
        citiesPage.getNameInputField().sendKeys(city);
        citiesPage.getSaveButton().click();
        citiesPage.waitSuccessfullyMessageToBeVisible();
        Assert.assertTrue(citiesPage.getMessageSuccessfullyText().getText().contains("Saved successfully"),
                "Saved successfully message is missing");
    }

    @Test(priority = 40)
    public void editCity() {
        String oldCityName = "Aleksandra Markovic's city";
        String newCityName = "Aleksandra Markovic's city Edited";

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchInputField().sendKeys(oldCityName);
        citiesPage.waitForRowsToAppear(1);
        citiesPage.getEditButton(1).click();
        citiesPage.getNameInputField().click();
        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(newCityName).perform();
        citiesPage.waitForSaveButtonToBeClicable();
        citiesPage.getSaveButton().click();
        citiesPage.waitSuccessfullyMessageToBeVisible();
        Assert.assertTrue(citiesPage.getMessageSuccessfullyText().getText().contains("Saved successfully"),
                "Saved successfully message is missing");
    }

    @Test(priority = 50)
    public void searchCity() {
        String cityName = "Aleksandra Markovic's city Edited";

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchInputField().sendKeys(cityName);
        citiesPage.waitForRowsToAppear(1);
        Assert.assertEquals(citiesPage.getTableCell(1, 2).getText(), cityName,
                "City you searched for is not in database");
    }

    @Test(priority = 60)
    public void deleteCity() {
        String cityName = "Aleksandra Markovic's city Edited";

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchInputField().sendKeys(cityName);
        citiesPage.waitForRowsToAppear(1);
        Assert.assertEquals(citiesPage.getTableCell(1, 2).getText(), cityName,
                "City you searched for is not in database");
        citiesPage.getDeleteButtonFromRow(1).click();
        citiesPage.waitForDialogueToBeVisible();
        citiesPage.getDeleteButtonFromDialogue().click();
        citiesPage.waitSuccessfullyMessageToBeVisible();
        Assert.assertTrue(citiesPage.getMessageSuccessfullyText().getText().contains("Deleted successfully"),
                "Deleted successfully message is missing");
    }

}