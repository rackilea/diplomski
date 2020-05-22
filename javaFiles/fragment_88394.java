import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

    public static void main(String ... x){
        // Path to Marionette driver
        System.setProperty("webdriver.gecko.driver", "C:/serwery/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("btnG")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.quit();
    }
}