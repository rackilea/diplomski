// suppose this is your WebDriver instance
WebDriver yourDriver = new RemoteWebDriver(your_hub_url, your_desired_capabilities);

......
// elementId would be 'loadingPanel'
boolean isElementNotDisplayed(final String elementId, final int timeoutInSeconds) {
    try {
        ExpectedCondition condition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(final WebDriver webDriver) {
                WebElement element = webDriver.findElement(By.id(elementId));
                return !element.isDisplayed();
            }
        };
        Wait w = new WebDriverWait(yourDriver, timeoutInSeconds);
        w.until(condition);
    } catch (Exception ex) {
        // if it gets here it is because the element is still displayed after timeoutInSeconds
        // insert code most suitable for you
    }
        return true;
}