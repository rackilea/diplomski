package navi;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Monika {
    private static WebDriver driver;

    WebDriverWait wait5s = new WebDriverWait(driver,5);

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pburgr\\Desktop\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\pburgr\\AppData\\Local\\Google\\Chrome\\User Data");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();}   
    @Before
    public void setUp() {}
    @After
    public void tearDown() {}
    @AfterClass
    public static void tearDownClass() {driver.close();driver.quit();}
    @Test
    public void autofill_first_value () throws InterruptedException, AWTException {

        driver.get("https://www.google.com/");
        WebElement fld_search = wait5s.until(ExpectedConditions.elementToBeClickable(By.id("lst-ib")));
        fld_search.click();
        fld_search.sendKeys("french");

        Robot rob = new Robot();                          
        rob.keyPress(KeyEvent.VK_DOWN); 
        rob.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(1000);

        String foo1 = driver.findElement(By.xpath("//*[@id=\"sbse0\"]/div[2]/b")).getText();
        fld_search.sendKeys(" " + foo1);

        Thread.sleep(5000);

        // hit the search button...
    }
}