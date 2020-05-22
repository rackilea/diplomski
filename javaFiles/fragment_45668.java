public static void switchToNewTab() {
    openNewTab();
    String subWindowHandler = null;

    Set<String> handles = getDriver().getWindowHandles();
    Iterator<String> iterator = handles.iterator();
    while (iterator.hasNext()) {
        subWindowHandler = iterator.next();
    }
    getDriver().switchTo().window(subWindowHandler);
}

public static void openNewTab() {
    ((JavascriptExecutor) getDriver()).executeScript("window.open('about:blank','_blank');");
}

public static void firstRunWebpage() {
    getDriver().get("https://employers.indeed.com/p#post-job");
    getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("login-email-input"))).sendKeys("example@email.com");
    getDriver().findElement(By.id("login-password-input")).sendKeys("examplepass");
    //getDriver().findElement(By.xpath("//*[@id=\"label-login-rememberme-checkbox\"]")).click(); //typically already checked
    getDriver().findElement(By.id("login-submit-button")).click();
}

public static void afterFirstRun() {
    switchToNewTab();
    getDriver().get("https://employers.indeed.com/p#post-job");
}