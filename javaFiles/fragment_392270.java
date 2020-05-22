public class BaseTest {

protected String browser; // add a property to hold this value

@BeforeMethod(alwaysRun = true)
@Parameters({ "platform", "browser", "version" })
public void setup(String platform, String browser, String version)
        throws MalformedURLException, InterruptedException {   
    this.browser = browser; // store the given browser string
    RemoteWebDriver driver = null;      
    //important: Thread local!
    threadedDriver = new ThreadLocal<RemoteWebDriver>();
    DesiredCapabilities caps = new DesiredCapabilities();
    // Platforms
    if (platform.equalsIgnoreCase("windows"))
        caps.setPlatform(Platform.WINDOWS);