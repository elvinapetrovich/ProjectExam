package profilePolicyTest;

import org.apache.log4j.Logger;
import org.junit.Test;
import parentTest.ParentTest;

public class ProfilePolicyTest extends ParentTest {
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void profilePolicyTest() {
        loginPage.openPage();
        loginPage.enterLogin("olgaautotest@mailinator.com");
        loginPage.enterPass("123456");
        loginPage.clickOnCookies();
        loginPage.clickOnSubmitButton();
        homePage.checkCurrentUrl();
        homePage.clickonRules();
        rulesAndRegulationsPage.clickOnPrivacyPolicy();
        rulesAndRegulationsPage.isConfirmationPresent();
        logger.info("Confirmation is present");
    }
}
