public void clickCheckboxInTable(String value, String action) {
  // Assume the WebDriver instance is stored in a class-level
  // variable named 'driver'.
  WebElement tableCell = driver.findElement(By.xpath("//td[contains(., '" + value + "')]"));
  WebElement checkbox = tableCell.findElement(By.xpath("..//input[contains(@name, '" + action + "')]"));
  checkbox.click();
}