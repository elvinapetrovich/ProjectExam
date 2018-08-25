package pages;

import Libs.ActionWithOurElements;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FacebookPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    ActionWithOurElements actionWithOurElements;
    @FindBy(id="email")
    private WebElement userFBInput;
    @FindBy(id = "pass")
    private WebElement FBpassInput;
    @FindBy (id="loginbutton")
    private WebElement enterFB;

    public FacebookPage(WebDriver webDriver) {
        this.webDriver=webDriver;
    }

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void openFbPage() {
        try {
            webDriver.get("https://www.facebook.com/login");
            logger.info("Facebook page opened");
        } catch (Exception e) {
            logger.info("Can't open Facebook page");
            Assert.fail("Can't open Facebook page");
        }
    }

    public void enterFBLogin(String FBlogin) {
        actionWithOurElements.EnterTextToElement(userFBInput, FBlogin);
    }

    public void enterFBPass(String FBpass) {
        actionWithOurElements.EnterTextToElement(FBpassInput, FBpass);
    }
    public void clickToSubmit () {
        actionWithOurElements.clickOnElement(enterFB);
    }

    @After
    public void tearDownFB() {
        webDriver.quit();

    }
}

