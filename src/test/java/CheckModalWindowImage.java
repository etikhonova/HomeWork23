import pages.W3layoutsPage;
import webDriverFactory.WebDriverChromeOptions;
import baseTests.DefaultUItest;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CheckModalWindowImage extends DefaultUItest {
    @Before
    public void setUp(){
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(CheckModalWindowImage.class);
        driver = WebDriverChromeOptions.startChromeKiosk();
        logger.info("driver started");
    }
    @Test
    public void ifWindowIsModal (){

        W3layoutsPage w3layoutsPage = new W3layoutsPage(driver);
        Assert.assertEquals("Close", w3layoutsPage.open(driver).imageClick().getCloseButtonName());

    }
}
