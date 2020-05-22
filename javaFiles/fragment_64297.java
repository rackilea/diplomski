import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class NewTesting {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver","C:\\path\\to\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://book.theautomatedtester.co.uk/chapter1");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testExample() {
        WebElement element = driver.findElement(By.id("verifybutton"));
    }

}