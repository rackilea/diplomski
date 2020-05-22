public class MasterPage { // can be abstract

    protected WebDriver driver;

    public MasterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "OkBtn")
    private WebElement okBtn;

    protected void clickOk() {
        okBtn.click();
    }
}