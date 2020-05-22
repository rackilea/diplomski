protected synchronized boolean isElementPresent(WebElement element) {
        boolean elementPresenceCheck = false;
        Wait<WebDriver> wait=null;
        try {
            wait = new FluentWait<WebDriver>((WebDriver) driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(1,
                    TimeUnit.SECONDS);
            elementPresenceCheck = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
            return elementPresenceCheck;
        }catch(Exception e) {
            return elementPresenceCheck;
        }
    }