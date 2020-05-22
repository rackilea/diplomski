public class WebDriverRule extends ExternalResource {
  public WebDriver driver;

  @Override
  protected void before() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://www.google.com/");
  }

  @Override
  protected void after() {
    driver.quit();
  }
}