// Initialize instance
Actions action = new Actions(webdriver);

// Find element to focus inside iframe
WebElement we = webdriver.findElement("<find element you wish to focus>");

// Perform move action
action.moveToElement(we).build().perform();