package pages;
import helpers.PropertiesReader;
import org.openqa.selenium.WebDriver;

public class DefaultPage {
    protected WebDriver driver;
    public PropertiesReader reader = new PropertiesReader("my.properties");

}
