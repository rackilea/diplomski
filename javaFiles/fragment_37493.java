By locator = By.cssSelector("#rfr-details-dialog-" + rfrNumber + " .modal-title");
int timeoutInSeconds = 10;

WebElement foundElement = new WebDriverWait(webdriver, timeoutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));

System.out.println("tite: " + foundElement.getText());