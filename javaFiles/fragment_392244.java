public ManualShipmentModal(WebDriver driver)
{
    this.driver = driver;
    long timeOutInSeconds = 10; // just an arbitrary value example
    this.wait = new WebDriverWait(driver, timeOutInSeconds);

    // the rest of your constructor as in the original code
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
    PageFactory.initElements(factory, this);
}