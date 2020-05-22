/* 
code snippet will Wait 30 seconds for 
an element to be present on the page and check for its 
presence once every 5 seconds.
*/
Wait wait = new FluentWait(driver)
    .withTimeout(30, SECONDS)
    .pollingEvery(5, SECONDS)
    .ignoring(NoSuchElementException.class);

WebElement foo = wait.until(new Function() {
    public WebElement apply(WebDriver driver) {
        return driver.findElement(By.id("foo"));
    }
});