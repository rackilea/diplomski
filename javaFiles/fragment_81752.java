import java.util.List;
    import java.util.concurrent.TimeUnit;

    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.firefox.FirefoxDriver;

    public class Q44970712_stale 
    {

        static WebDriver driver = null;

        public static void main(String[] args)  throws InterruptedException
        {
        System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.co.in/");
        //driver.findElement(By.xpath("//input[class='gsfi']")).sendKeys("Banduchode");;
        WebElement search=driver.findElement(By.cssSelector("input#lst-ib"));
        search.sendKeys("Banduchode");
        search.sendKeys(Keys.ENTER);
        printLinksName();



        for(int i=0;i<5;i++)
        {
            List<WebElement> fiveLinks=driver.findElements(By.xpath(".//*[@id='nav']/tbody/tr/td/a"));
            System.out.println(fiveLinks.get(i).getText());
            fiveLinks.get(i).click();
            Thread.sleep(5000);
            printLinksName();
        }
        }

        public static void printLinksName() throws InterruptedException
        {
            List<WebElement> allLinks=driver.findElements(By.xpath("//*[@id='rso']/div/div/div/div/div/h3/a"));
            System.out.println(allLinks.size()); 

            //print all list        
            for(int i=0;i<allLinks.size();i++)
            {
            System.out.println("Sno"+(i+1)+":"+allLinks.get(i).getText());

            }   
        }

    }