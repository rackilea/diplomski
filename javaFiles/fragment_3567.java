List<WebElement> inputs = driver.findElements(By.tagName("input"));

for (WebElement input : inputs) {
    ((JavascriptExecutor) driver).executeScript(
                "arguments[0].removeAttribute('readonly','readonly')",input);
}