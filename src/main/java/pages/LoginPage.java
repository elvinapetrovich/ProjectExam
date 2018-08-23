package pages;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends ParentPage {
    @FindBy(name = "loginEmail")
    private WebElement userNameInput;
    @FindBy(name = "loginPassword")
    private WebElement PasswordInput;
    @FindBy(id = "loginSubmit")
    private WebElement submitButton;
    @FindBy (xpath = ".//*[@type='button']")
    private WebElement Cookies;
    Logger logger=Logger.getLogger(getClass());


    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login.html");
    }

    public void openPage() {
        try {
            webDriver.get(baseUrl + "/login.html");
            logger.info("LoginPage was opened");
        } catch (Exception e) {
            logger.info("Can't open LoginPage");
            Assert.fail("Can't open LoginPage");
        }
    }

    public void enterLogin(String login) {
        actionWithOurElements.EnterTextToElement
                (userNameInput, login);
    }

    public void enterPass(String pass) {
        actionWithOurElements.EnterTextToElement
                (PasswordInput, pass);
    }

    public void clickOnSubmitButton() {
        actionWithOurElements.clickOnElement(submitButton);
    }
public void clickOnCookies () {
        actionWithOurElements.clickOnElement(".//*[@type='button' and text()='Accept']");
}
}
