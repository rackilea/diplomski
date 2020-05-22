Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
       .withTimeout(30, SECONDS)
       .pollingEvery(5, SECONDS)
       .ignoring( NoSuchElementException.class, ElementNotFoundException.class );
// using a customized expected condition
WebElement foo1 = wait.until(new Function<WebDriver, WebElement>() {
     public WebElement apply( WebDriver driver ) {
       // do something here if you want
       return driver.findElement( By.id("foo") );
     }
   });
// using a built-in expected condition
WebElement foo2 = wait.until( ExpectedConditions.visibilityOfElementLocated(
     By.id("foo") );