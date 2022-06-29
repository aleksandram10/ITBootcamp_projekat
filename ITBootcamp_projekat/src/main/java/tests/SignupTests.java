package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

    @Test(priority = 10)
    public void visitSignupPage() {
        navPage.getSignupButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Current site path do not contains /signup in URL");
    }

    @Test(priority = 20)
    public void verifyInputTypes() {
        navPage.getSignupButton().click();
        Assert.assertEquals(signupPage.getEmailInputField().getAttribute("type"), "email",
                "Email input field attribute type is not email");
        Assert.assertEquals(signupPage.getPasswordInputField().getAttribute("type"), "password",
                "Password input field attribute type is not password");
        Assert.assertEquals(signupPage.getConfirmPasswordInputField().getAttribute("type"), "password",
                "Confirm Password input field attribute type is not password");
    }

    @Test(priority = 30)
    public void verifyErrorIsDisplayedWhenUserAlreadyExist() {
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.getSignupButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Current site path do not contains /signup in URL");
        signupPage.getNameInputField().sendKeys(name);
        signupPage.getEmailInputField().sendKeys(email);
        signupPage.getPasswordInputField().sendKeys(password);
        signupPage.getConfirmPasswordInputField().sendKeys(confirmPassword);
        signupPage.getSignMeUpButton().click();
        messagePopUpPage.waitForMessagePopUpToBeShown();
        Assert.assertEquals(messagePopUpPage.loginAndSignupErrorMessages().getText(), "E-mail already exists",
                "Error message is not E-mail already exists" );
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Current site path do not contains /signup in URL");
    }

    @Test(priority = 40)
    public void verifySignup() {
        String name = "Aleksandra Markovic";
        String email = "aleksandra.markovic@itbootcamp.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.getSignupButton().click();
        signupPage.getNameInputField().sendKeys(name);
        signupPage.getEmailInputField().sendKeys(email);
        signupPage.getPasswordInputField().sendKeys(password);
        signupPage.getConfirmPasswordInputField().sendKeys(confirmPassword);
        signupPage.getSignMeUpButton().click();
        messagePopUpPage.waitSignupVerifyYourAccountDialog();
        Assert.assertTrue(messagePopUpPage.getVerifyYourAccountDialogMessage().
                        getText().contains("IMPORTANT: Verify your account"),
                "Verify your account message is missing");
        messagePopUpPage.getVerifyYourAccountCloseButton().click();
        navPage.getLogoutButton().click();

    }


}