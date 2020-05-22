WebElement waitsss(WebDriver driver, By elementIdentifier){
     Wait<WebDriver> wait =
                new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
                                                 .pollingEvery(1, TimeUnit.SECONDS)
                                                 .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebDriver, WebElement>()
                {
                    public WebElement apply(WebDriver driver) {
                           return driver.findElement(elementIdentifier);
                    }
                });
}