import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Q45519900_amazon_list 
{

    public static void main(String[] args) 
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Utility\\BrowserDrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions"); 
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.amazon.in/s/ref=sr_pg_2?rh=n%3A1571271031%2Cn%3A%211571272031%2Cn%3A1968024031%2Cn%3A1968093031%2Cp_n_pct-off-with-tax%3A70-%2Cp_98%3A10440597031&page=2&bbn=1968093031&ie=UTF8&qid=1501915937&lo=apparel");
        List<WebElement> element = driver.findElements(By.xpath("//ul[@id='s-results-list-atf']/li[starts-with(@id, 'result_')]/div/div[@class='a-row a-spacing-none']/div/a/h2"));
        System.out.println("Total items : "+element.size());
        for (WebElement my_element:element)
        {
        String title = my_element.getAttribute("innerHTML");
        System.out.println("Item name is : "+title);
        }

    }

}