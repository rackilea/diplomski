import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClassSampleUsingThreadLocal {
    private static final ThreadLocal<RemoteWebDriver> drivers = new ThreadLocal<>();

    @BeforeMethod
    public void instantiateBrowser(ITestResult testResult) {
        RemoteWebDriver driver = new ChromeDriver();
        drivers.set(driver);
    }

    @Test(dataProvider = "dp")
    public void testMethod(String url) {
        Reporter.log("Launching the URL [" + url + "] on Thread [" + Thread.currentThread().getId() + "]", true);
        driver().get(url);
        Reporter.log("Page Title :" + driver().getTitle(), true);
    }

    @DataProvider(name = "dp", parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                {"http://www.google.com"}, {"http://www.stackoverflow.com"}, {"http://facebook.com"}
        };
    }

    @AfterMethod
    public void cleanupBrowser() {
        RemoteWebDriver driver = driver();
        driver.quit();
    }

    private RemoteWebDriver driver() {
        RemoteWebDriver driver = drivers.get();
        if (driver == null) {
            throw new IllegalStateException("Driver should have not been null.");
        }
        return driver;
    }

}