try{
   (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by)));
   driver.findElement(by).click();
   }
catch(TimeoutException te){
}