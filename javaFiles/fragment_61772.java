public class AndroidBasePage implements IPage {

    protected WebDriver driver;

    private WebDriverWait driverWait;

    public AndroidBasePage() {
        driver = SeleniumManager.activeBrowser();
         //only one driverwait for a page instance
        driverWait = new WebDriverWait(driver, 30);//time should be configurable
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }


    protected void driverWaitPresenceOfElement(String xpath) {
       driverWait.until(presenceOfElementLocated(By.xpath(xpath)));
    }
}