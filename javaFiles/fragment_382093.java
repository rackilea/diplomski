private static Boolean execute(WebDriver driver)
{
    pause(3000);
    return !((JavascriptExecutor) driver)
        .executeScript("return performance.timing.loadEventEnd", new Object[0])
        .equals("0");
}