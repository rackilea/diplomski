private static WebDriverWait wait = new WebDriverWait(driver, 60);
private static JavascriptExecutor js  = (JavascriptExecutor) driver;

public static void waitForPageLoaded() {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    Boolean res = (js.executeScript("return document.readyState").equals("complete"));
                    System.out.println("[DEBUG] waitForPageLoaded: " + res);
                    return res;
            }
    });
}