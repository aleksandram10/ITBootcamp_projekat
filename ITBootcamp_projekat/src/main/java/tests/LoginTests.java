package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test(priority = 10)
    public void visitLoginPage() {
        navPage.getLanguageButton().click();
        navPage.getLanguageButtonEN().click();
        navPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }

    @Test(priority = 20)
    public void verifyInputTypes() {
        navPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getEmailInputField().getAttribute("type"), "email",
                "Email input field attribute type is not email");
        Assert.assertEquals(loginPage.getPasswordInputField().getAttribute("type"), "password",
                "Password input field attribute type is not password");
    }

    @Test(priority = 30)
    public void verifyErrorIsDisplayedWhenUserDoesNotExist() {
        String email = "non-existing-user@gmal.com";
        String password = "password123";
        navPage.getLoginButton().click();
        loginPage.getEmailInputField().sendKeys(email);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForMessagePopUpToBeShown();
        Assert.assertEquals(messagePopUpPage.loginAndSignupErrorMessages().getText(), "User does not exists",
                "Error message is not User does not exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }

    @Test(priority = 40)
    public void verifyErrorIsDisplayedWhenPasswordIsWrong() {
        String email = "admin@admin.com";
        String password = "password123";
        navPage.getLoginButton().click();
        loginPage.getEmailInputField().sendKeys(email);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForMessagePopUpToBeShown();
        Assert.assertEquals(messagePopUpPage.loginAndSignupErrorMessages().getText(), "Wrong password",
                "Error message is not Wrong password");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }

    @Test(priority = 50)
    public void verifyLogin() {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.getLoginButton().click();
        loginPage.getEmailInputField().sendKeys(email);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        loginPage.waitForTitleToChange();
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "Current site path do not contains /home in URL");
    }

    @Test(priority = 60)
    public void verifyLogout() {
        Assert.assertTrue(navPage.getLogoutButton().isDisplayed(), "Logout button is not visible on the page");
        navPage.getLogoutButton().click();
    }

}
