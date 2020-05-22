package <yourpackagename>;

<import required packages>

@Listeners(MyTestListenerAdapter.class)
public class Home {
    private AppiumDriver<?> driver;

    <define your variables>

    public void setUp(String port, String deviceOS, String DSN, String deviceName) throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformVersion", deviceOS);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", DSN);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1200);
        capabilities.setCapability("appPackage", "<your app package>");
        capabilities.setCapability("appActivity", "<your launcher activity>");
        final String url = "http://127.0.0.1:"+port+"/wd/hub";
        driver = new AndroidDriver<>(new URL(url), capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void HomeVerification(String DSN, String deviceName) throws InterruptedException, ParseException
    {
        System.out.println(deviceName+": Testing Home Section-");

        <--Your code to perform any additional task before execution-->
    }

    public void Test1_VideoPlaybackVerification(String DSN, String deviceName) throws InterruptedException, ParseException
    {       
        //Video playback verification code starts
        .
        .
        //End of code for Video playback verification
    }

    public void Test2_PauseVerification(String deviceName) throws InterruptedException, ParseException
    {

        //Video pause verification code starts
        .
        .
        //End of code for Video pause verification
    }

    @Parameters({"port", "deviceOS", "DSN", "deviceName"})
    @Test (retryAnalyzer = Retry.class)
    public void TestRun(String port, String deviceOS, String DSN, String deviceName) throws InterruptedException, ParseException, MalformedURLException {

        try {
            setUp(port, deviceOS, DSN, deviceName);
            HomeVerification(DSN, deviceName);
            Test1_VideoPlaybackVerification(DSN, deviceName);
            Test2_PauseVerification(deviceName);
        } catch (WebDriverException e) {
            // TODO Auto-generated catch block
            Reporter.log(deviceName+": Error observed while executing script!", true);
            Assert.assertTrue(false); //Fails the test case
        }

    }

    @AfterTest
    public void End() {
        driver.quit();
    }
}