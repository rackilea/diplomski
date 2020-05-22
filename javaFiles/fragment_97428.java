public void login(final String user) {
    webDriver.findElement(By.id("login")).click();
    final WebElement loginForm = webDriver.findElement(By.class("popover-content)).findElement(By.id("loginForm"));
    loginForm.findElement(By.id("username")).sendKeys(user);
    loginForm.findElement(By.id("password"))password.sendKeys(dslConstants.PASSWORD);
    loginForm.submit();
}