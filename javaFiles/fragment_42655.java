protected final void waitForElementPresent(final By by) {
   seleniumContext.getWebDriverWait().until(new ExpectedCondition() {
      @Override
      public Boolean apply(WebDriver driver) {
        try {
          driver.findElement(by);
          return true;
        } catch (NoSuchElementException e) {
          return false;
        }
      }
   });
}