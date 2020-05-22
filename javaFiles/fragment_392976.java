public void fluentWait(final By by)
{
    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
               .withTimeout(60, TimeUnit.SECONDS)
               .pollingEvery(5, TimeUnit.SECONDS)
               .ignoring(NoSuchElementException.class);

           WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
             public WebElement apply(WebDriver driver) {
               return driver.findElement(by);
             }
           });
}