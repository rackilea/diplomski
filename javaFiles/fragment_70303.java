import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptAlertTest {

public static void main(String[] args) {

    WebDriver myTestDriver = new FirefoxDriver();
    myTestDriver.get("...blablabla....");

    myTestDriver.manage().window().maximize();

    myTestDriver.findElement(By.xpath("//input[@value = 'alert']")).click();

    Alert javascriptAlert = myTestDriver.switchTo().alert();
    System.out.println(javascriptAlert.getText()); // Get text on alert box
    javascriptAlert.accept();

    System.out.println("*************prompt******************************************");

    myTestDriver.findElement(By.xpath("//input[@value = 'prompt']")).click();

    Alert javascriptprompt = myTestDriver.switchTo().alert();
    javascriptprompt.sendKeys("This is Selenium Training");

    System.out.println(javascriptprompt.getText()); // Get text on alert box

    javascriptprompt.accept();
    javascriptprompt = myTestDriver.switchTo().alert();

    System.out.println(javascriptprompt.getText()); // Get text on alert box
    javascriptprompt.accept();

    myTestDriver.findElement(By.xpath("//input[@value = 'prompt']")).click();

    javascriptprompt = myTestDriver.switchTo().alert();

    System.out.println(javascriptprompt.getText()); // Get text on alert box

    javascriptprompt.dismiss();
    javascriptprompt = myTestDriver.switchTo().alert();

    System.out.println(javascriptprompt.getText()); // Get text on alert box
    javascriptprompt.accept();

    System.out.println("***********************************confirm dialog box****************************");
    myTestDriver.findElement(By.xpath("//input[@value = 'confirm']")).click();

    Alert javascriptconfirm = myTestDriver.switchTo().alert();
    javascriptconfirm.accept();

    javascriptconfirm = myTestDriver.switchTo().alert();
    System.out.println(javascriptconfirm.getText()); // Get text on alert box
    javascriptconfirm.accept();

    myTestDriver.findElement(By.xpath("//input[@value = 'confirm']")).click();
    javascriptconfirm = myTestDriver.switchTo().alert();

    javascriptconfirm.dismiss();
    javascriptconfirm = myTestDriver.switchTo().alert();
    System.out.println(javascriptconfirm.getText()); // Get text on alert box
    javascriptconfirm.accept();

}
}