List<WebElement> errorExplanation = driver.findElements(By.id("error_explanation"));
if (!errorExplanation.isEmpty() && errorExplanation.get(0).isDisplayed())
{
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("soumya50@toobler.com");
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    driver.findElement(By.id("user_password")).sendKeys("password");
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    driver.findElement(By.id("user_current_password")).sendKeys("password");
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    driver.findElement(By.name("commit")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.linkText("LOGOUT")).click();
}
else
{
    driver.findElement(By.linkText("REQUEST A PERMIT")).click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}