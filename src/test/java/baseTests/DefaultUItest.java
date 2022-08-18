package baseTests;
import helpers.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;

public class DefaultUItest {
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(DefaultUItest.class);
    protected WebDriver driver;
    public  PropertiesReader reader = new PropertiesReader("my.properties");

    @After
    public void setDown(){
        if(driver!=null) {
            driver.quit();
        }
    logger.info("Драйвер закрыт");
    }
}
