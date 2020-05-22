package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Q45433269_Tooltip 
{
    @Test
    public void  getToolTipText() throws InterruptedException
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
        WebDriver driver =  new FirefoxDriver();
        driver.navigate().to("http://demoqa.com/tooltip/");
        driver.findElement(By.id("age")).click();
        Actions act = new Actions(driver);
        WebElement age_purpose = driver.findElement(By.xpath("//div[contains(@id, 'ui-id-')]/div[@class='ui-tooltip-content']"));
        act.moveToElement(age_purpose).perform();
        String tooltiptextreal = age_purpose.getText();
        System.out.println("Tooltip text is : "+tooltiptextreal);
    }
}