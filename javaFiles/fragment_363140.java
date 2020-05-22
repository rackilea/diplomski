try
{
    Thread.sleep(10000); // 1000 milliseconds is one second.
}
catch (InterruptedException ex)
{
    Thread.currentThread().interrupt();
}
WebElement username = driver.findElement(By.id("UserName"));
username.sendKeys(username);