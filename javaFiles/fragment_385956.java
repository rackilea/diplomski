import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest()
{
    public static void main(String[] args) 
    {
        try
        {
            System.setProperty("webdriver.ie.driver"," IEDriverServer.exe");
            WebDriver driver = new InternetExplorerDriver();
            driver.get("http://www.ultimateprivateservers.com/index.php?a=in&u=IkovPS");
            Thread.sleep(3000); //use the wait as shown below
            WebElement button = driver.findElement(By.linkText("Enter and vote"));
            button.click();
            driver.close();
            driver.quit();
        }catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}