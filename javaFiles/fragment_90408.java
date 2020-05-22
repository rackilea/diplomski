public boolean isElementPresent(By by) {
    try {
      driver.findElements(by);
      return true;
    } catch (org.openqa.selenium.NoSuchElementException e) {
      return false;
    }
}