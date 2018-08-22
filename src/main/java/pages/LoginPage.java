package pages;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage{

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login.html");
    }
    public void openPage () {
        try {
            webDriver.get(baseUrl+ expectedUrl);
            logger.info("LoginPage was opened");
        } catch (Exception e) {
            logger.info("Can't open LoginPage");
            Assert.fail("Can't open LoginPage");
        }
    }
    public void
}
