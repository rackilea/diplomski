import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import locators.login; // if your test class and login class in the same package there is no need to import it

public class Sortowanie{

private WebDriver driver;
private String baseUrl;
private StringBuffer verificationErrors = new StringBuffer();

@BeforeClass(alwaysRun = true)
public void setUp() throws Exception {
  driver = new ChromeDriver(); // for some reason FF don't want to load this page for me
  baseUrl = "https://en-testwebapi.poczta-polska.pl/";
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}


@Test
@Parameters({"login", "password"})
  public void testSortowanie(String login, String password) throws Exception {
  login L = PageFactory.initElements(driver, login.class); //
  driver.get(baseUrl);
  L.Login(driver, login, password);

}

@AfterClass(alwaysRun = true)
public void tearDown() throws Exception {
  driver.quit();
  String verificationErrorString = verificationErrors.toString();
  if (!"".equals(verificationErrorString)) {
  fail(verificationErrorString);
}
}
}