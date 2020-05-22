public class TestCase {

    Browser browser = new Browser();
    Selenium selenium;

    // constructor
    public TestCase(){
        selenium = browser.getSelenium();
    }
    ...