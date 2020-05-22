public class WebTest

{
static ChromeDriverService service = null;
static WebDriver driver = null;

@BeforeClass
static public void setupOnce() throws IOException {

    // Setup ChromeDriver with Verbosity on - perhaps control via system property - off by default?
    service = new ChromeDriverService.Builder()
            .withVerbose(true)
            .usingAnyFreePort()
            .build();

    service.start();

    // Setup locator to find unpacked Portable chrome exe
    ChromeLocator locator = new ChromeLocator();

    // Use service + capabilities from locator to open driver with settings and chrome bin
    driver = new RemoteWebDriver(service.getUrl(), locator.getCapabilities());
}

@AfterClass
static public void teardownOnce() {
    if (null != service) {
        service.stop();
        service = null;
    }
}
@Test
public void testGoogleSearch() throws InterruptedException, IOException {
    driver.get("http://www.google.com/xhtml");
    assertEquals("Google", driver.getTitle());

    WebElement searchBox = driver.findElement(By.name("q"));
    String searchString = "ChromeDriver";
    searchBox.sendKeys(searchString);
    searchBox.submit();

    String source = driver.getPageSource().toString();
    assertTrue("Expected DOCTYPE in\n" + source,
            source.contains("DOCTYPE"));
    driver.quit();
    service.stop();

}