WebDriverWait wait = new WebDriverWait(driver, 10);

// Step 1: wait for page to navigate to search results
// identified by <h1> with text 'Search - [search term]'
wait.until(ExpectedConditions.presenceOfElementLocated(
  By.xpath("//h1[contains(text(), 'Search - " + searchData + "')]")));