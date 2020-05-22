public boolean checkIfDisplayed(By by) {
    if (isElementPresent(by) {
    if (driver.findElement(by).isDisplayed()) {
        return true;
    } else
        return false;
    } else
        return false;
}