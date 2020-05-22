WebDriverWait wait = new WebDriverWait(driver, 10);

List<WebElement> checkboxes = wait.until(ExpectedConditions
        .presenceOfAllElementsLocatedBy(By.cssSelector("tr[role=row] input#chkSelect[type=checkBox]")));

for (WebElement checkbox : checkboxes) {
    wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
}