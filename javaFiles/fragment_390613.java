import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;

Boolean result = true;

try {
    selenium = new DefaultSelenium("localhost", 4444, "*iexplore", "http://www.google.com/");
    selenium.start();
    selenium.windowMaximize();

    selenium.open("/");
    selenium.waitForPageToLoad("30000");      

    if (!selenium.isTextPresent("Google")) result = false;
} catch (Exception ex) {
    ex.printStackTrace();
    log.error(ex.getMessage());
     SampleResult.setSuccessful(false);
     SampleResult.setResponseCode("500");
     SampleResult.setResponseMessage(ex.getMessage());
} finally {
    selenium.stop();
}

SampleResult.setSuccessful(result);
return result;