import pages.MainPage;
import webDriverFactory.WebDriverChromeOptions;
import baseTests.DefaultUItest;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FirstSearchResultForOtus  extends DefaultUItest {
    @Before
    public void setUp(){
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(FirstSearchResultForOtus.class);
        driver = WebDriverChromeOptions.startChromeHeadless();
        logger.info("Драйвер поднят");

    }
    @Test
    public void SearchResultForOtus(){

        String title = new MainPage(driver).open().searchByText("Otus").getFirstLinkUrl();
        Assert.assertEquals(title,"https://otus.com/");
    }
}
