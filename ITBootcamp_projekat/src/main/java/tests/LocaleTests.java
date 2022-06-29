package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

    @Test(priority = 10)
    public void setLocaleToES() {
        navPage.getLanguageButton().click();
        navPage.getLanguageButtonES().click();
        Assert.assertTrue(navPage.getPageHeader().getText().contains("Página de aterrizaje"),
                "Page Header does not contain Página de aterrizaje");
    }

    @Test(priority = 20)
    public void setLocaleToEN() {
        navPage.getLanguageButton().click();
        navPage.getLanguageButtonEN().click();
        Assert.assertTrue(navPage.getPageHeader().getText().contains("Landing"),
                "Page Header does not contain Landing");
    }

    @Test(priority = 30)
    public void setLocaleToCN() {
        navPage.getLanguageButton().click();
        navPage.getLanguageButtonCN().click();
        Assert.assertTrue(navPage.getPageHeader().getText().contains("首页"),
                "Page Header does not contain 首页");
    }

    @Test(priority = 40)
    public void setLocaleToFR() {
        navPage.getLanguageButton().click();
        navPage.getLanguageButtonFR().click();
        Assert.assertTrue(navPage.getPageHeader().getText().contains("Page d'atterrissage"),
                "Page Header does not contain Page d'atterrissage");
    }

}