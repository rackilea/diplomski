protected boolean isElementHiddenNow(String id) {
    turnOffImplicitWaits();
    boolean result = ExpectedConditions.invisibilityOfElementLocated(By.id(id)).apply(driver);
    turnOnImplicitWaits();
    return result;
}

private void turnOffImplicitWaits() {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
}

private void turnOnImplicitWaits() {
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}