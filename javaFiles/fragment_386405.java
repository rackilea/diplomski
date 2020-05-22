public static void runTestClock(WebDriver driver)
{
    if (driver.findElements(By.cssSelector(".redClockBigIcon")).isEmpty())
    {
        System.out.println("Stock is closed");
    }
    else if (driver.findElements(By.cssSelector(".greenClockBigIcon")).isEmpty())
    {
        System.out.println("Stock is open");
    }
    driver.navigate().back();
}