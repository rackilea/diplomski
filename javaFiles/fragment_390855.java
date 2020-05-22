public class BaseSteps extends DriverFactory {

     WebDriver driver = getDriver();

     @After
     public void close_browser_window(Scenario scenario) throws Exception {
      if (scenario.isFailed()) {
       scenario.embed(((TakesScreenshot) 
       driver).getScreenshotAs(OutputType.BYTES), "image/png");
}

}