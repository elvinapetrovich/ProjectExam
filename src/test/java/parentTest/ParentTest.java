package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class ParentTest {
   protected WebDriver webDriver;
 //  Logger logger=Logger.getLogger(getClass());
   protected LoginPage loginPage;
   protected HomePage homePage;


    @Before
    public void setUP() {
        File file=new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
       // logger.info("Chrome started");
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            loginPage = new LoginPage(webDriver);
            homePage = new HomePage(webDriver);
        }
    protected void checkAC(String message, boolean actual, boolean expected) {
        if (actual != expected) {
          //  logger.info("AC failed: " + message);
            Assert.assertEquals(message, expected, actual);
        }
    }
    @After
    public void tearDown () {
        webDriver.quit();
    }
}