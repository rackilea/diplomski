import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    public class MouseHoverFirefox {

        public static void main(String[] args) {

            System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
            WebDriver driver=new FirefoxDriver();
            driver.get("http://www.executeautomation.com/demosite/index.html");
            new WebDriverWait(driver, 20).until(ExpectedConditions.titleIs("Execute Automation"));
            new Actions(driver).moveToElement(new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='Automation Tools']")))).build().perform();
            new Actions(driver).moveToElement(new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='active has-sub']/a/span//following::ul[1]/li[@class='has-sub']/a/span[@id='Selenium']")))).build().perform();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='active has-sub']/a/span//following::ul[1]/li/a/span[@id='Selenium']//following::ul[1]/li/a/span[text()='Selenium WebDriver']"))).click();
        }
    }