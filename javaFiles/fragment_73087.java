import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestSelenium {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "res/chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        driver = new ChromeDriver(capabilities);

        driver.get("http://www.yatra.com/");

        List<WebElement> radio = driver.findElements(By.xpath("//a[@data-flighttrip]"));
        System.out.println(radio.size());

        driver.quit();
    }
}