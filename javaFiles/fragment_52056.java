public class SampleTest {

  WebDriver driver;
  String host;

  @Parameters({"host"})
  @BeforeTest
  public void beforeTest(String host) {
    this.host = host;
  }

  @Test(priority = 1, enabled = true)
  public void method1() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.google.com");
  }

  @Test(priority = 2, enabled = true)
  public void method2() throws Exception {
    driver.findElement(By.id("lst-ib")).sendKeys(this.host);
  }

}