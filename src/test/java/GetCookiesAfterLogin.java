import webDriverFactory.WebDriverChromeOptions;
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

public class GetCookiesAfterLogin extends DefaultUItest {
    @Before
    public void setUp(){
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(GetCookiesAfterLogin.class);
        driver = WebDriverChromeOptions.startChromeFullScrean();
        logger.info("driver started");
    }
    @Test
    public void getCookies () {
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(GetCookiesAfterLogin.class);
        driver.get("https://otus.ru/");
        logger.info("auth");
        auth();
        Assert.assertNotNull(driver.manage().getCookies());
        logger.info(driver.manage().getCookies());
    }
    private void auth (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginButtonWait = wait
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//button[@class='header2__auth js-open-modal']")));
        loginButtonWait.click();
        WebElement loginEmailWait =wait.
                 until(ExpectedConditions
                       .elementToBeClickable(By.xpath("//form[@action='/login/']//input[@name='email']")));
        loginEmailWait.sendKeys("hell_me@list.ru");
    driver.findElement(By.xpath("//form[@action='/login/']//input[@name='password']")).sendKeys("Ee12345!");
    driver.findElement(By.xpath("//form[@action='/login/']//button[@type='submit']")).click();
    }
}

