WebDriverWait wait = new WebDriverWait(driver, 10);

List<WebElement> rows = wait.until(ExpectedConditions
        .presenceOfAllElementsLocatedBy(By.cssSelector("tr[role=row]")));

for (WebElement row : rows) {
    List<WebElement> checkboxes = driver.findElements(By.cssSelector("input#chkSelect[type=checkBox]"));
    wait.until(ExpectedConditions.elementToBeClickable(checkboxes.get(0))).click();
    wait.until(ExpectedConditions.elementToBeClickable(checkboxes.get(1))).click();

}