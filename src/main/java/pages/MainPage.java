package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends DefaultPage {

    @FindBy(id = "search_form_input_homepage")
    private WebElement searchfield ;

    public MainPage (WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public SearchPage searchByText (String text) {
        searchfield.sendKeys(text);
        searchfield.sendKeys(Keys.ENTER);
        return new SearchPage(driver);
    }

    public MainPage open (){
        driver.get("https://duckduckgo.com/");
        return this;
    }
}
