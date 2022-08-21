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

public class GetCookiesAfterLoginTest extends DefaultUItest {
    @Before
    public void setUp(){
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(GetCookiesAfterLoginTest.class);
        driver = WebDriverChromeOptions.startChromeFullScrean();
        logger.info("driver started");
    }
    @Test
    public void getCookies () {
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(GetCookiesAfterLoginTest.class);
        driver.get(reader.getProperty("otus.ru.link"));
        logger.info("auth");
        auth();
        Assert.assertNotNull(driver.manage().getCookies());
        logger.info(driver.manage().getCookies());
    }
    private void auth (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButtonWait = wait
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//button[@class='header2__auth js-open-modal']")));
        loginButtonWait.click();
        WebElement loginFormWait = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//form[@action='/login/']"))));
        loginFormWait.findElement(By.xpath(".//input[@name='email']")).sendKeys(reader.getProperty("otus.login"));
        loginFormWait.findElement(By.xpath(".//input[@name='password']")).sendKeys(reader.getProperty("otus.password"));
        loginFormWait.findElement(By.xpath(".//button[@type='submit']")).click();
    }
}

