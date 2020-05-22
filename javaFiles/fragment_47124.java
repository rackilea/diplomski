public class Page1 extends MasterPage {

    public Page1(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="field")
    private WebElement elementOne;

    public Page2 completePageAndGoToPageTwo() {
        elementOne.click();
        clickOk();
        return new Page2(driver);
    }
}