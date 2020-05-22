import org.testng.annotations.*; 
import static org.testng.Assert.*; 
import org.openqa.selenium.*; 
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestArea { 
    private WebDriver driver; 

    @BeforeClass(alwaysRun = true) 
    public void setUp() throws Exception { 
        System.setProperty("webdriver.gecko.driver", "C:\\Automation\\SeleniumFiles\\Browser Drivers\\geckodriver.exe"); 
        driver = new FirefoxDriver();
    }

    @Test 
    public void Example() throws Exception { 
        driver.get( "http://MyWebsite"); 
        assertTrue(isElementPresent( By.xpath("The Element I want look for ")));
    } 

    @AfterClass(alwaysRun = true) 
    public void tearDown() throws Exception { 
        driver.quit(); 
    }

    private boolean isElementPresent(By by) { 
        try { 
            driver.findElement(by); 
            return true; 
        } catch (NoSuchElementException e) { 
            return false; 
        } 
    } 
}