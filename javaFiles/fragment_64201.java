List<WebElement> elements = driver.findElements(By.tagName("select")); 

for (WebElement element: elements) {
      dropdown = new Select(element);
      dropdown.selectByIndex(1);
}