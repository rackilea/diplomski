import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShonaDriver {

public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "bin/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(
            "https://careernavigator.naukri.com/sales-executive-retail-careers-in-mahindra-and-mahindra-financial-services-15731");
    /// the row xpath that ws once here found nothing
    List<WebElement> column = driver.findElements(
            By.xpath("(//*[name()='svg'])[2]//*[name()='text']//*[name()='tspan' and (@dy=4 or @dy='3.5')]"));
    int spreadSheetRowNum = 0;
    int spreadSheetColumnNum = 0;
    WebElement f1 = driver.findElement(By.id("f1"));
    for (int i = 0; i < column.size(); i++) {
        if (column.get(i).getText().equalsIgnoreCase("1")) {
            // reached end of meaningful fields
            break;
        }
        if (i % 3 == 0) {// start of new row
            spreadSheetRowNum++;
            System.out.println("here create row: " + spreadSheetRowNum);
            spreadSheetColumnNum = 1;// assuming excel column A is column 1
        } else {
            spreadSheetColumnNum++;
        }

        System.out.println("for column list " + i + " text is:");
        System.out.println(column.get(i).getText());
        System.out.println("write it to row " + spreadSheetRowNum + " column " + spreadSheetColumnNum);
    }

    String[] f1Arr = f1.getText().split("\n");
    System.out.println("if you prefer to use the f1 array, its contents are:");
    for (int i = 0; i < f1Arr.length; i++) {
        System.out.println("f1[" + i + "] = " + f1Arr[i]);
    }
    driver.close();
}
}