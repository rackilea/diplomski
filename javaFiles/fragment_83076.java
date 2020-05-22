public class CallUrl {
 WebDriver driver;
 Properties prop;

 @BeforeClass
 public void loadProps(){
    prop = new Properties();
    FileInputStream fis = new FileInputStream("C:\\Users\\xxxx\\URL.properties");
    prop.load(fis);
 }


 @BeforeTest
 public void openBrowser() throws IOException {
  System.setProperty("webdriver.chrome.driver", "C:\\Users\\xxxx\\chromedriver.exe");
  String browserType = prop.getProperty("Browser");
  if (browserType.equals("Chrome")) {
   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ashish\\Documents\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
   driver = new ChromeDriver(options);
  } else if (browserType.equals("FireFox")) {
   driver = new FirefoxDriver();
  }
 }

 @Test
 public void openURL() throws IOException {
  driver.get(prop.getProperty("URL"));
  WebDriverWait myDynamicElement = new WebDriverWait(driver, 30);
  myDynamicElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='userName']")));
 }

 @Test(dependsOnMethods = {
  "openURL"
 })
 public void loginToTours() throws InterruptedException, IOException {
  driver.findElement(By.name("userName")).sendKeys(prop.getProperty("login"));
  driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
  driver.findElement(By.name("login")).click();
 }
}