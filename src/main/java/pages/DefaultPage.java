package pages;
import helpers.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class DefaultPage {
    protected WebDriver driver;
    public PropertiesReader reader = new PropertiesReader("my.properties");


}
