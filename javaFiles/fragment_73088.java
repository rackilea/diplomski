import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestSelenium {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        File file = new File("D:\\IEDriverServer.exe");

        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
        DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
        cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

        WebDriver driver=new InternetExplorerDriver(cap);

        driver.get("http://www.yatra.com/");
        driver.manage().window().maximize();

        List<WebElement> radio = driver.findElements(By.xpath("//a[@data-flighttrip]"));
        System.out.println(radio.size());

        driver.quit();
    }
}