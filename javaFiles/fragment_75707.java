public class BaseClass{

  public static WebDriver driver;

  public BaseClass(WebDriver _driver){
      driver = _driver;
      FirstName = driver.findElement(By.name("firstname"));
      LastName  = driver.findElement(By.name("LastName"));
  }

  public  WebElement FirstName;
  public  WebElement LastName;
  //Rest of the code