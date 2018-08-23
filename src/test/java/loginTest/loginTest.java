package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import parentTest.ParentTest;

public class loginTest extends ParentTest {
    @Test
    public void ValidLogin () {
        loginPage.openPage();
        loginPage.enterLogin("olgaautotest@mailinator.com");
        loginPage.enterPass("123456");
        loginPage.clickOnCookies();
        loginPage.clickOnSubmitButton();
        homePage.checkCurrentUrl();
        checkAC("Uvologo isn't present",homePage.isUvoPresent(),true);
    }
    @Test
public void InValidLogin () {
        loginPage.openPage();
        loginPage.enterLogin("olgaautotest@mailinator.com");
        loginPage.enterPass("987654");
        loginPage.clickOnCookies();
        loginPage.clickOnSubmitButton();
        loginPage.checkCurrentUrl();
    Assert.assertEquals("Url is not expected","https://www.uvocorp.com/login.html",
            webDriver.getCurrentUrl());
}
}
