public class QCEntry
{
    private WebDriver browser;
    private String baseUrl;

    @BeforeClass
    public void setUp() throws Exception
    {
        browser = new FirefoxDriver();
        baseUrl = "http://www.example.org/";
        browser.get(baseUrl);
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        browser.findElement(By.id("ctl00_cphMain_txtUsername")).clear();
    }

    @Test
    public void testImportexport1() throws Exception
    {
        By somethingLocator = By.id("ctl00_ctl00_cphMain_cphTest_LocationPanel_ddlSiteLevel3");
        for (int row = 1; row < s.getRows(); row++)
        {
            WebDriverWait wait5 = new WebDriverWait(browser, 100);
            browser.findElement(somethingLocator).click();
            wait5.until(ExpectedConditions.visibilityOfElementLocated(somethingLocator)).sendKeys("Ames");
        }
    }
}