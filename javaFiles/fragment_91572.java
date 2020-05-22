import com.hp.lft.report.CaptureLevel;
import com.hp.lft.report.ModifiableReportConfiguration;
import com.hp.lft.report.Reporter;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import core.Selenium;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.*;
import java.io.File;
import java.net.URI;


public class SeleniumTest extends Selenium {

    WebDriver driver;
    Browser browser;

    public SeleniumTest() {
        //Change this constructor to private if you supply your own public constructor
    }


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        instance = new SeleniumTest();
        globalSetup(SeleniumTest.class);


    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();

    }

    @Before
    public void setUp() throws Exception {


    /*
        This will not work in LeanFT 14.00, so we are commenting it out

        ModifiableSDKConfiguration sdkConfig = new ModifiableSDKConfiguration();

        sdkConfig.setServerAddress(new URI("ws://localhost:5095"));
        SDK.init(sdkConfig);
        ModifiableReportConfiguration reportConfig = new ModifiableReportConfiguration();
        reportConfig.setOverrideExisting(true);
        reportConfig.setTargetDirectory("C:\\Users\\user\\IdeaProjects\\LeanFT_Selenium\\RunResults");
        reportConfig.setReportFolder("LastRun");
        reportConfig.setTitle("Summary");
        reportConfig.setDescription("Description");
        reportConfig.setSnapshotsLevel(CaptureLevel.All);

        Reporter.init(reportConfig);
    */
    ChromeOptions options = new ChromeOptions();
    options.addExtensions(new File
            ("C:\\Program Files (x86)\\HP\\Unified Functional Testing\\Installations\\Chrome\\Agent.crx"));
    System.setProperty("webdriver.chrome.driver",
            "C:\\HP_Reporting\\Webdriver\\chromedriver.exe");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    driver = new ChromeDriver(options);
    browser = BrowserFactory.attach(new BrowserDescription.Builder()
            .type(BrowserType.CHROME).build());
}

@After
public void tearDown() throws Exception {

    driver.quit();
    browser = null;

    //Reporter.generateReport();
    //SDK.cleanup();
}

@Test
public void test() throws Exception {

    driver.get("https://www.google.co.uk/");

}