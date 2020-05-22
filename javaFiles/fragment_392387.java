public class PageChecker extends Verifier {
  private WebDriverRule webDriverRule;
  private enabled = true;

  public PageChecker(WebDriverRule webDriverRule) {
    this.webDriverRule = webDriverRule;
  }

  public void disable() {
    this.enabled = false;
  }

  @Override
  public void verify() {
    if(enabled && notValid())
      throw new AssertionError("foo");
  }

  private boolean notValid() {
    WebDriver driver = webDriverRule.driver;
    //do something with driver
  }
}