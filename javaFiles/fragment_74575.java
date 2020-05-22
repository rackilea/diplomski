import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class userURL {

    public static void main(String[] args) {

        String baseURL = "https://www.nokia.com";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your language: ");
        String lang = scanner.nextLine();
        scanner.close();
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumUtilities\\BrowserDrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("disable-infobars");
        WebDriver driver = new ChromeDriver(options);
        driver.get(baseURL + "/" + lang);
        System.out.println(driver.getCurrentUrl());
    }
}