package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;
    private By firstLink = By.xpath("//article[@id='r1-0']/div/div/a");

    public SearchPage (WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstLinkUrl (){
        return driver.findElement(firstLink).getAttribute("href");

    }


}
