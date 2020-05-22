import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

class Main{
    public static void main(String args[])throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shash\\Desktop\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1024,768");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(capabilities);

        driver.get("http://www.irctc.co.in");//It will open the website
        Thread.sleep(5000);//For Entering the Captcha before 5sec

        driver.findElement(By.xpath("//input[@id='usernameId']")).sendKeys("");//enter username

        driver.findElement(By.xpath("//input[@class='loginPassword']")).sendKeys("");//enter password

        driver.findElement(By.xpath("//input[@id='loginbutton']")).click();//clicks on sign in

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='jpform:fromStation']")).sendKeys("H NIZAMUDDIN - NZM");//origin station


        driver.findElement(By.xpath("//input[@id='jpform:toStation']")).sendKeys("KOTA JN - KOTA");//destination station


        driver.findElement(By.xpath("//input[@id='jpform:journeyDateInputDate']")).sendKeys("18-05-2017");//Date Of Journey

        driver.findElement(By.xpath("//input[@id='jpform:jpsubmit']")).click();//Clicks to find the trains
        driver.findElement(By.xpath("//a[@id='cllink-12060-CC-0']")).click();//Clicks the class of train to find available seats
        Thread.sleep(3000);
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver)
                .executeScript("document.getElementById(\"12060-CC-GN-0\").click()");
        }
    }
}