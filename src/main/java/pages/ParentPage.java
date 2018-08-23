package pages;

import Libs.ActionWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    Logger logger=Logger.getLogger(getClass());
    WebDriver webDriver;
    String expectedUrl;
    final String baseUrl="https://www.uvocorp.com";
    ActionWithOurElements actionWithOurElements;

    public ParentPage (WebDriver webDriver, String expectedUrl)  {
        this.webDriver=webDriver;
        this.expectedUrl=baseUrl +expectedUrl;
        PageFactory.initElements(webDriver,this);
        actionWithOurElements=new ActionWithOurElements(webDriver);
    }

    public String getCurrentUrl () {
        return webDriver.getCurrentUrl();
    }
    public void checkCurrentUrl () {
        try {
            Assert.assertEquals("Url is not expected",expectedUrl,getCurrentUrl());
        } catch (Exception e) {
            logger.error("Can't work with url");
            Assert.fail("Can't work with url");
        }
    }

}
