import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.W3layoutsPage;
import webDriverFactory.WebDriverChromeOptions;
import baseTests.DefaultUItest;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;


public class CheckModalWindowImageTest extends DefaultUItest {
    @Before
    public void setUp(){
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(CheckModalWindowImageTest.class);
        driver = WebDriverChromeOptions.startChromeKiosk();
        logger.info("driver started");
    }
    @Test
    public void ifModalWindowPresent (){
        By modalWindow = By.xpath("//div[@class='pp_pic_holder light_rounded']");
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(CheckModalWindowImageTest.class);
        W3layoutsPage w3layoutsPage = new W3layoutsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            logger.info("Ждем модельное окно до нажатия на картинку");
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(modalWindow)));
            }
        catch (NoSuchElementException e) {
            logger.info("нет модального окна, можно жать на картинку");
            w3layoutsPage.open(driver).imageClick();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(modalWindow)));
            Assert.assertTrue(driver.findElement(modalWindow).isDisplayed());
        }
    }
}
