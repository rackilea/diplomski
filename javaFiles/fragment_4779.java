import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ch1 {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        try{
            System.setProperty("webdriver.chrome.driver", "C://testing/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver,15);
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            driver.get("https://www.via.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wzrk-button-container']/button[1]")));
            driver.findElement(By.xpath("//div[@class='wzrk-button-container']/button[1]")).click();
            driver.findElement(By.xpath("//div[@class='element relElements airportElements']/input[1]")).sendKeys("BLR");
            driver.findElement(By.xpath("//div[@class='calendar-icon']")).click();
            WebElement date = driver.findElement(By.xpath("//*[@id='depart-cal']/div[3]//div[text()='19']"));
            wait.until(ExpectedConditions.visibilityOf(date));
            date.click();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            driver.quit();
        }
    }

}