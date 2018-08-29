package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RulesAndRegulationsPage extends ParentPage {
    Logger logger = Logger.getLogger(getClass());
    @FindBy(xpath = ".//a[@href='privacy_policy.html']")
    private WebElement privacy;
    @FindBy(xpath = ".//*[contains(text(),'This is version 1.0.0 (confirmed by you 2018-07-09)')]")
    private WebElement confirm;

    public RulesAndRegulationsPage(WebDriver webDriver) {
        super(webDriver, "/backend/rules_and_regulations.html");
    }

    public void clickOnPrivacyPolicy() {
        actionWithOurElements.clickOnElement(privacy);
    }

    public boolean isConfirmationPresent() {
        return actionWithOurElements.isElementDisplay(confirm);
    }
}
