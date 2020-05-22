WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("audio")));

if (driver instanceof JavascriptExecutor) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].volume = 0.5;", element);
}