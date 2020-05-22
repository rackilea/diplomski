public class GoogleHomePO extends LoadableComponent<GoogleHomePO>{

    @FindBy(name="q")
    private WebElement searchTextBox;

    public GoogleHomePO() {
        DriverFactory.getDriver().get("https://www.google.com/");
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void enterSearch(String search) {
        searchTextBox.sendKeys(search);
    }
}