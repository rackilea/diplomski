import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Lists;

@RunWith(Parameterized.class)
public class ExplicitWaitNavigationTest {
    /** IP configuration for the proxy.*/
    private static final String PROXY_IP = "";
    /** Port configuration for the proxy.*/
    private static final int PROXY_PORT = 8080;

    /** The url the test will navigate to.*/
    private static final String TEST_URL = "http://the-internet.herokuapp.com/dropdown";
    /** Maximum time to wait for a page to load.*/
    private static final int PAGE_LOAD_SECONDS = 15;
    /** Maximum time to wait for javascript to complete.*/
    private static final int SCRIPT_LOAD_SECONDS = 15;

    /** ExpectedCondition used to validate the navigation state.*/
    private ExpectedCondition<Boolean> navTestCondition;
    /** The URL to be tested in this instance.*/
    private String url;
    /** WebDriver reference used for testing navigation through proxy.*/
    private WebDriver webDriver;

    /**
     * Assembles the Constructor arguments for testing.
     * Due to test parameterization, each pair is run as a separate test.
     * @return Object array of test parameters.
     */
    @Parameters
    public static Object[] createParameters() {
        List<Object[]> params = Lists.newArrayList();
        String url = TEST_URL;

        //Test that url exactly matches
        ExpectedCondition<Boolean> test = ExpectedConditions.urlToBe(url);
        params.add(new Object[]{test, url});

        //Test if the url matches a regex?
        test = ExpectedConditions.urlMatches(url); //regex match? I'm not great with regex
        params.add(new Object[]{test, url});

        //Test if the url contains the base site, or other fragment information
        test = ExpectedConditions.urlContains("dropdown");
        params.add(new Object[]{test, url});

        // Test if the page title exactly matches expectation.
        test = ExpectedConditions.titleIs("The Internet");
        params.add(new Object[]{test, url});

        //Test if the page title somewhat matches expectation
        test = ExpectedConditions.titleContains("Internet");
        params.add(new Object[]{test, url});


        return params.toArray(new Object[]{});        
    }

    /**
     * Turns off noisy logging that is on by default in the Selenium structure.
     */
    @BeforeClass
    public static void disableHttpUnitOutput() {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
    }

    /**
     * Constructor.
     * @param waitCondition Expected condition to validate in this effort.
     * @param url URL being navigated to.
     */
    public ExplicitWaitNavigationTest(ExpectedCondition<Boolean> waitCondition, String url) {
        this.navTestCondition = waitCondition;
        this.url = url;
    }

    /**
     * Configures the Driver for this test instance.
     */
    @Before
    public void setupDriver() {
        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        String proxyConfig = PROXY_IP + ":" + PROXY_PORT;
        proxy.setHttpProxy(proxyConfig);
        proxy.setSslProxy(proxyConfig);
        proxy.setFtpProxy(proxyConfig);


        DesiredCapabilities dc = DesiredCapabilities.firefox();
        dc.setCapability(CapabilityType.PROXY, proxy);

        FirefoxDriver ffd = new FirefoxDriver(dc);
        ffd.manage().timeouts().pageLoadTimeout(PAGE_LOAD_SECONDS, TimeUnit.SECONDS); 
        ffd.manage().timeouts().setScriptTimeout(SCRIPT_LOAD_SECONDS, TimeUnit.SECONDS); 

        //XXX EventFiringWebDriver decoration
        EventFiringWebDriver efwd = new EventFiringWebDriver(ffd);
        efwd.register(new AbstractWebDriverEventListener() {            
            @Override
            public void onException(Throwable throwable, WebDriver driver) {
                System.out.println("Exception thrown from within the EventFiringWebDriver");
                throwable.printStackTrace();
            }            
            @Override
            public void beforeNavigateTo(String url, WebDriver driver) {
                System.out.println("Before NavigateTo :: " + url);
            }            
            @Override
            public void afterNavigateTo(String url, WebDriver driver) {
                System.out.println("After NavigateTo :: " + url);
            }

        });  

        webDriver = efwd;

    }

    /**
     * Test instance which attempts to navigate to the configured url and establishes an ExplicitWait to confirm
     * navigation before continuing with the test event.
     */
    @Test
    public void testPageLoadFeedback() {
        webDriver.navigate().to(url);
        /*
         * FIXME: How long are you actually willing to wait.
         * 
         * It's my understanding that if the wait value is less than the implicit wait, then the looping capabilities of
         * the ExplicitWait are never really leveraged.
         * 
         * Note that the time value is the maximum time to wait. If the condition validates before the time specified
         * then the process will continue.
         */

        WebDriverWait wait = new WebDriverWait(webDriver, PAGE_LOAD_SECONDS * 2);
        wait.pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(navTestCondition);
        // If we get to this line then the test passed and we should be on the page.
        System.out.println("Navigation Succeeded!");
    }    

    /**
     * Cleanup method to close any browsers used by the test session.
     */
    @After
    public void cleanupTest() {
        //XXX:  To leave the browser open, comment out the @After of this method.
        for (String handle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(handle);
            webDriver.close();
        }
    }

}