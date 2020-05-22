public class StackOverFlow{

    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 40);
        driver.get("https://givingday.northeastern.edu/pages/giving-page-2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".campaign-tiles-content")));
        scrollDown(driver, "scroll(0,500)");
        driver.findElement(By.xpath("//a[text()='Club Sports']/parent::div/following-sibling::div[@class='inline-b']/descendant::button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".giving-form-billing")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[text()='Archery']")));
        driver.findElement(By.xpath("//h3[text()='Archery']")).click();
    }

    public static void scrollDown(WebDriver driver, String YoffSet){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(YoffSet);
}

}