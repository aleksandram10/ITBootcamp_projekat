package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {

    @Test(priority = 10)
    public void ForbidsVisitsToHomeUrlIfNotAuthenticated() {
        navPage.goToHomeUrl();
        navPage.waitForLoginPageToLoadUp();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }

    @Test(priority = 20)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        navPage.goToProfileUrl();
        navPage.waitForLoginPageToLoadUp();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }

    @Test(priority = 30)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        navPage.goToAdminCitiesUrl();
        navPage.waitForLoginPageToLoadUp();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }

    @Test(priority = 40)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        navPage.goToAdminUsersUrl();
        navPage.waitForLoginPageToLoadUp();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }

}