import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicAuthentication_FF 
{
    public static void main(String[] args) 
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
        WebDriver driver =  new FirefoxDriver();
        driver.navigate().to("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}