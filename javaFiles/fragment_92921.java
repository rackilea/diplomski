String JS_ELEMENT_IS_SCROLLABLE = 
    "return arguments[0].scrollHeight > arguments[0].offsetHeight;";

JavascriptExecutor jse = (JavascriptExecutor)webDriver;

WebElement container = driver.findElement(By.cssSelector(".checkout-mini-cart"));
Boolean isScrollable = (Boolean)jse.executeScript(JS_ELEMENT_IS_SCROLLABLE, container);