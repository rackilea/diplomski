import java.net.URI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class A_demo 
{
    public static void main(String[] args) throws URISyntaxException 
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Utility\\BrowserDrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/package-summary.html");
        String CurrentURL = driver.getCurrentUrl();
        URI uri = new URI(CurrentURL);
        System.out.println("Scheme: "+uri.getScheme());
        System.out.println("Scheme-specific-part: "+uri.getSchemeSpecificPart());
        System.out.println("Authority: "+uri.getAuthority());
        System.out.println("User-info: "+uri.getUserInfo());
        System.out.println("Host: "+uri.getHost());
        System.out.println("Port: "+uri.getPort());
        System.out.println("Path: "+uri.getScheme());
        System.out.println("Query: "+uri.getQuery());
        System.out.println("Fragment: "+uri.getFragment());
    }
}