import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;


public  class Test {
public void screenShot() {
    // driver is your WebDriver
    File screenshot = ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(screenshot, new File(fileName));

}