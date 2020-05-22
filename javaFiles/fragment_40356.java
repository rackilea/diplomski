By css = By.cssSelector("[placeholder='Please Select a Customer...']");
By option = By.xpath("//li[@role='option'][text()='Customer 2']");
WebDriverWait wait = new WebDriverWait(driver, 10);

//Click the dropdown to populate the list
WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(css));
dropdown.click();

//Click the option. Notice the xpath is using the text of the customer
WebElement value = wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
value.click();