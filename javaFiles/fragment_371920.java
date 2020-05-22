public class A_demo 
{
    public static void main(String[] args) throws Exception 
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        ((JavascriptExecutor)driver).executeScript("return arguments[0].scrollIntoView(true);", new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Multi Select List Demo']"))));
        WebElement california = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='multi-select']//option[@value='California']")));
        WebElement ohio = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='multi-select']//option[@value='Ohio']")));
        WebElement washington = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='multi-select']//option[@value='Washington']")));
        new Actions(driver).moveToElement(california).click().build().perform();
        new Actions(driver).keyDown(Keys.CONTROL).click(ohio).keyUp(Keys.CONTROL).build().perform();
        new Actions(driver).keyDown(Keys.CONTROL).click(washington).keyUp(Keys.CONTROL).build().perform();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='printAll' and @value='Print All']"))).click();
        System.out.println(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='getall-selected']"))).getText());
        driver.quit();
    }
}