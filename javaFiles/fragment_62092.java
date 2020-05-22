public class PageObjectXYZ {

    private AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().className("android.widget.TextView")")
    private List<MobileElements> someTextViews;

    public PageObjectXYZ(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickTheOneIWant(String option){
        for(MobileElement me: someTextViews){
            if(me.getAttribute("text").equals(option)){
                this.driver.tap(1, me, 1000);
                break;
            }
        }
    }
}