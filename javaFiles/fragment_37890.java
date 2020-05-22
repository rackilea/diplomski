private static WebElement findElement(WebDriver driver, By locator) {
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(90, TimeUnit.SECONDS)
            .pollingEvery(5, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}