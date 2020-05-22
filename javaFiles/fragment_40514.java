public class FooTest {

    @Test
    public void foo() {
        WebDriver driver = new FirefoxDriver();
        FooPage page = new FooPage();
        PageFactory.initElements(driver, page);
        driver.get("file:///Users/aarondavis/Desktop/index.html");
        for (WebElement elem : page.getPointers()) {
            System.out.println(elem);
            System.out.println(elem.getAttribute("style"));
        }
        driver.quit();
    }

    public static final class FooPage {
        @FindBy(xpath = "//slider/span")
        private List<WebElement> pointers;

        public List<WebElement> getPointers() {
            return pointers;
        }
    }
}