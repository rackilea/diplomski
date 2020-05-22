import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;   

public class TestNGFile {
    @Test
    public void Test1() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Roey\\Desktop\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        String baseurl = "http://newtours.demoaut.com/" ;
        chromeDriver.get(baseurl);
        String expectedTitle = "Welcome: Mercury Tours" ;
        String actualTitle = chromeDriver.getTitle();
        AssertJUnit.assertEquals(actualTitle , expectedTitle) ;
        chromeDriver.quit();
    }
}