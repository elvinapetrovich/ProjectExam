package Libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait20;

    public ActionWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait20 = new WebDriverWait(webDriver, 20);
    }

    public void EnterTextToElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputed into element");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can't work with element" + e);
        Assert.fail("Can't work with element" + e);
    }

    public boolean isElementDisplay(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Element is displayed" + state);
            return state;
        } catch (Exception e) {
            logger.info("Element is display" + false);
            return false;
        }
    }
    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(webElement));
            //webDriverWait20.until(ExpectedConditions.not
            //(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
    public void clickOnElement(String xPathLocator) {
        try {
            WebElement webElement= webDriver.findElement(By.xpath(xPathLocator));
            clickOnElement(webElement);
        }catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
}
