package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends DefaultPage {

    private By firstLink = By.xpath("//article[@id='r1-0']/div/div/a");

    public SearchPage (WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }


    public String getFirstLinkUrl (){
        return driver.findElement(firstLink).getAttribute("href");

    }


}
