package parentTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.RulesAndRegulationsPage;
import java.io.File;
import java.util.concurrent.TimeUnit;


public class ParentTest {
   protected WebDriver webDriver;
   protected LoginPage loginPage;
   protected HomePage homePage;
   protected RulesAndRegulationsPage rulesAndRegulationsPage;
   Logger logger=Logger.getLogger(getClass());



    @Before
    public void setUP() {
        File file=new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
       // logger.info("Chrome started");
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            loginPage = new LoginPage(webDriver);
            homePage = new HomePage(webDriver);
            rulesAndRegulationsPage=new RulesAndRegulationsPage(webDriver);
        }
    protected void checkAC(String message, boolean actual, boolean expected) {
        if (actual != expected) {
         logger.info("AC failed: " + message);
            Assert.assertEquals(message, expected, actual);
        }
    }
    @After
    public void tearDown () {
        webDriver.quit();
    }
}