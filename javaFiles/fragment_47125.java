public class Page2 extends MasterPage {

    public Page2(WebDriver driver) {
        super(driver);
    }

    @FindBy (id="field")
    private WebElement elementTwo;

    public void completePageTwo() {
        elementTwo.click();
        clickOk();
    }
}