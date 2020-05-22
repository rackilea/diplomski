import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClassSample {
    private static final String WEBDRIVER = "driver";

    @BeforeMethod
    public void instantiateBrowser(ITestResult testResult) {
        RemoteWebDriver driver = new ChromeDriver();
        testResult.setAttribute(WEBDRIVER, driver);
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
                {"http://www.google.com"},
                {"http://www.stackoverflow.com"},
                {"http://facebook.com"}
        };
    }

    @AfterMethod
    public void cleanupBrowser(ITestResult testResult) {
        RemoteWebDriver driver = driver(testResult);
        driver.quit();
    }

    private RemoteWebDriver driver() {
        return driver(Reporter.getCurrentTestResult());
    }

    private RemoteWebDriver driver(ITestResult testResult) {
        if (testResult == null) {
            throw new IllegalStateException("testResult should have not been null.");
        }
        Object driverObject = testResult.getAttribute(WEBDRIVER);
        if (driverObject == null) {
            throw new IllegalStateException("Driver should have not been null.");
        }
        if (!(driverObject instanceof RemoteWebDriver)) {
            throw new IllegalStateException("Driver is not a valid webdriver object");
        }
        return (RemoteWebDriver) driverObject;
    }
}