package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class W3layoutsPage extends DefaultPage{

    public W3layoutsPage (WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public W3layoutsPage open (WebDriver driver){
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
        return new W3layoutsPage(driver);
    }

    public W3layoutsPage imageClick (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement imageClickWait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='image-zoom']")));
        imageClickWait.click();
        return new W3layoutsPage(driver);
    }

    public String getCloseButtonName (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement closeButtonWait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='pp_fade']//a[@class='pp_close']")));
        return closeButtonWait.getText();
    }
}
