import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Sample {
    private WebDriver _driver;

    @Test
    public void IEconfiguration() throws Exception {
        System.setProperty("webdriver.ie.driver",
        "D:/Softwares/Selenium softwares/drivers/IEDriverServer.exe");
        _driver = new InternetExplorerDriver();
        login();
    }

    @Test
    public void FFconfiguration() throws Exception {
        _driver = new FirefoxDriver();
        login();
    }

    @Test
    public void CRconfiguration() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "D:/Softwares/Selenium softwares/drivers/chromedriver.exe");
        _driver = new ChromeDriver();
        //_driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        login();
    }

    public void login() throws Exception {
        _driver.get("http://www.google.com");
    }       
}