public class QQ_TT {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver,50); 
            driver.manage().window().maximize();    
            driver.get("https://www.gmail.com");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("headingText"))));
            driver.findElement(By.id("identifierId")).sendKeys("QQ_TT@gmail.com");
            driver.findElement(By.xpath("//span[text()='Next']")).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("headingText"))));
            driver.findElement(By.name("password")).sendKeys("qq_tt@stackoverflow");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']")));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
            driver.findElement(By.xpath("//span[text()='Next']")).click();

        }

    }