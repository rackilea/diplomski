By locator = By.xpath("//*[@id='Highchart_chart_property_hot_alerts']//div[contains(text(),'" + text + "')]");
WebElement foundElement = waitAndFindElement(locator);

private WebElement waitAndFindElement(By locator) {
  WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
  return wait.until(ExpectedConditions.presenceOfElementLocated(locator)));
}