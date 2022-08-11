import WebDriverFactory.WebDriverChromeOptions;
import baseTests.DefaultUItest;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckModalWindowImage extends DefaultUItest {
    @Before
    public void setUp(){
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(CheckModalWindowImage.class);
        driver = WebDriverChromeOptions.startChromeKiosk();
        logger.info("driver started");
    }
    @Test
    public void ifWindowIsModal (){
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement imageClickWait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='image-zoom']")));
        imageClickWait.click();
        WebElement closeButtonWait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='pp_fade']//a[@class='pp_close']")));
        System.out.println(driver.findElement(By.xpath("//div[@class='pp_fade']//a[@class='pp_close']")).getText());
        Assert.assertEquals("Close",closeButtonWait.getText());

    }
}
