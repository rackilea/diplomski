import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BaseClassForUiTest {

 public void test() throws Exception {              

      FirefoxDriver driver = new FirefoxDriver();
      EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);

      BaseClassForUiTest handler = new BaseClassForUiTest();
  eventDriver.register(handler);

      eventDriver.get("your url");

      //Now do your further stuff
}
}