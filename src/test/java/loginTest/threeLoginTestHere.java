package loginTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.util.concurrent.TimeUnit;

public class threeLoginTestHere extends ParentTest {

    @Test
    public void ValidLogin() {
        loginPage.openPage();
        loginPage.enterLogin("olgaautotest@mailinator.com");
        loginPage.enterPass("123456");
        loginPage.clickOnCookies();
        webDriver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        loginPage.clickOnSubmitButton();
        webDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        homePage.checkCurrentUrl();
        checkAC("Uvologo isn't present", homePage.isUvoPresent(), true);
    }

    @Test
    public void InValidLogin() {
        loginPage.openPage();
        loginPage.enterLogin("olgaautotest@mailinator.com");
        loginPage.enterPass("987654");
        loginPage.clickOnCookies();
        loginPage.clickOnSubmitButton();
        loginPage.checkCurrentUrl();
        Assert.assertEquals("Url is not expected", "https://www.uvocorp.com/login.html",
                webDriver.getCurrentUrl());
    }

    @Test
    public void BannedStatusLogin() {
        loginPage.openPage();
        loginPage.enterLogin("autologinbanned@mailinator.com");
        loginPage.enterPass("987654");
        loginPage.clickOnCookies();
        loginPage.clickOnSubmitButton();
        loginPage.checkCurrentUrl();
        checkAC("Banned text is not present", loginPage.isBannedTextPresent(), true);
    }
}
