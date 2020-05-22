import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

Boolean result = true;

try {
    driver = new HtmlUnitDriver();
    driver.setJavascriptEnabled(true);

    driver.get("http://www.google.com/");

    if (!driver.getTitle().contains("Google")) result = false;
} catch (Exception ex) {
    ex.printStackTrace();
    log.error(ex.getMessage());
     SampleResult.setSuccessful(false);
     SampleResult.setResponseCode("500");
     SampleResult.setResponseMessage(ex.getMessage());
} finally {
    driver.quit();
}

SampleResult.setSuccessful(result);
return result;