// Waiting 30 seconds for an element to be present on the page, checking
   // for its presence once every 5 seconds.
   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
       .withTimeout(30, SECONDS)
       .pollingEvery(5, SECONDS)
       .ignoring(NoSuchElementException.class);

   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
     public WebElement apply(WebDriver driver) {
       return driver.findElement(By.id("foo"));
     }
   });