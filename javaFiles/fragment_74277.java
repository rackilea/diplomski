import static  org.junit.Assert.*;

import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import play.test.Helpers;
import play.test.TestBrowser;
import play.test.WithBrowser;

public class BrowserFunctionalTest extends WithBrowser {

    // Just to make the WebClient visible at the test. Of course, this
    // could be an independent class to be reused by other tests or you
    // can create your own class that extends WithBrowser and hide all
    // the details from your tests.
    public static class CustomHtmlUnitDriver extends HtmlUnitDriver {
        @Override
        public WebClient getWebClient() {
            return super.getWebClient();
        }
    }

    @Override
    protected TestBrowser provideBrowser(int port) {
        // Here you need to create the TestBrowser for the class above.
        TestBrowser browser = Helpers.testBrowser(CustomHtmlUnitDriver.class, port);
        CustomHtmlUnitDriver driver = (CustomHtmlUnitDriver)browser.getDriver();
        WebClient client = driver.getWebClient();

        // do whatever you want with the WebClient

        return browser;
    }

    @Test
    public void runInBrowser() {
        browser.goTo("/");
        assertNotNull(browser.$("title").getText());
    }
}