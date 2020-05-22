//li[@id='sendSMS']/a

By byXpath = By.xpath("//a[.='Send SMS']");
WebElement myDynamicElement = (new WebDriverWait(driver, 10))
  .until(ExpectedConditions.presenceOfElementLocated(byXpath);
myDynamicElement.click();