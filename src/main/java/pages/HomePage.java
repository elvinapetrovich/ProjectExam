package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
@FindBy (xpath=".//*[@href='/main/logout']")
    private WebElement logo;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/orders/available.html");
    }


    public boolean isUvoPresent() {
        return actionWithOurElements.isElementDisplay(logo);
    }
}
