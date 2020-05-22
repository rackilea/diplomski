public class TestCase {

    Browser browser = new Browser();             // <-- this line changed
    Selenium selenium;

    // constructor
    public TestCase(Browser browser){            // <-- this line changed
        this.browser = browser;                  // <-- this line was added
        selenium = browser.getSelenium();
    }
    ...