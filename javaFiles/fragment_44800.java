public class HomePage {

  private Logger logger = LogManager.getRootLogger();

  @FindBy(xpath = "//nav//*[@id='li_myaccount']/a")
  private WebElement dropDownMenu;

  @FindBy(xpath = "//nav//*[@id='li_myaccount']/ul/li/a")
  private WebElement dropDownMenuOptions;

  public HomePage() {
    PageFactory.initElements(DriverManager.getWebDriver(), this);
  }

  public void clickOnMyAccountDropMenuAndSelectOption(String option) {
    WaitForElement.waitUntilElementIsVisible(dropDownMenu);
    dropDownMenu.click();

    Thread.sleep(2000); // wait 2 seconds until dropdown loads
    List<WebElement> options = DriverManager.getWebDriver().findElements(By.xpath("//nav//*[@id='li_myaccount']/ul/li/a"));

    for(WebElement o: options) {
      if(o.getText().equals(option)) {
        o.click();
        return;
      }
    }
  }

  public void clickOnLoginLink() {
    WaitForElement.waitUntilElementIsClickable(loginLink);
    loginLink.click();
    logger.info("Clicked on Login link");
  }
}