import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A_Chrome_General
{
    public static void main(String[] args) 
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Utility\\BrowserDrivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentLogging", "true");
        WebDriver driver = new ChromeDriver();
        driver.get("https://stackoverflow.com");
        System.out.println("Page Title is : "+driver.getTitle());
        driver.quit();
    }
}