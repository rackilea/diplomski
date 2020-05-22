public class GoogleSearchTest {
  private WebDriverRule webDriverRule = new WebDriverRule();
  private PageChecker pageChecker = new PageChecker(webDriverRule);

  @Rule
  public RuleChain driverAroundPageChecker
    = RuleChain.outerRule(webDriverRule).around(pageChecker);

  @Test
  public void testGoogleSearch() {
    GoogleHomePage googleHomePage = PageFactory.initElements(driver,
        GoogleHomePage.class);
    googleHomePage.searchGoogle("Selenium HQ");
    assert driver.getPageSource().contains("seleniumhq") : "Selenium headquarter search failed";
  }

  @Test
  public void testWithouPageCheck() {
    pageChecker.disable();
    //here is your real test
  }
}