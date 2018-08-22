package Libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionWithOurElements {
    WebDriver webDriver;
    Logger logger=Logger.getLogger(getClass());
    WebDriverWait webDriverWait20;

    public ActionWithOurElements (WebDriver webDriver) {
        this.webDriver=webDriver;
webDriverWait20=new WebDriverWait(webDriver,20)
    }
    public void EnterTextToElement
}
