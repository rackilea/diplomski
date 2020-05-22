WebDriverWait wait = new WebDriverWait(driver, 5);
try {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id('log_in_button')));
    return true;
} catch (TimeoutException exception) {
    return false;
}