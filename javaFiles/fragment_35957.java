package <yourpackagename>;

<import required packages>

public class Home {
    private AppiumDriver<?> driver;
    private static final String url = "http://0.0.0.0:4723/wd/hub";

    <define your variables>

    @Parameters({"deviceOS", "DSN"})
    @BeforeTest
    public void setUp(String deviceOS, String DSN) throws InterruptedException, MalformedURLException, ParseException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("deviceName", "FireTVStick");
        capabilities.setCapability("platformVersion", deviceOS);
        capabilities.setCapability("udid", DSN);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1200);
        capabilities.setCapability("appPackage", "<your app package>");
        capabilities.setCapability("appActivity", "<your launcher activity>");
        driver = new AndroidDriver<>(new URL(url), capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //End of Launch Code

        System.out.println("-Testing Home Section-");
    }   


    @Parameters({"DSN"})
    @Test
    public void Test1_VideoPlaybackVerification(String DSN) throws InterruptedException, ParseException{

        //Video playback verification code starts
        .
        .
        //End of code for Video playback verification
    }


    @Test //Test Case for Pause verification
    public void Test2_PauseVerification() throws InterruptedException, ParseException{
        //Video pause verification code starts
        .
        .
        //End of code for Video pause verification
    }

    @AfterTest
    public void End() {
        driver.quit();
    }
}