List<WebElement> uniqueLinks = driver.findElements(By.xpath("//a[contains(@href,'Link')][not(@href = following::a/@href)]"));

for ( int i = 0; i < uniqueLinks.size(); i++)
{
    new Actions(driver)
         .keyDown(Keys.CONTROL)
         .click(uniqueLinks.get(i))
         .keyUp(Keys.CONTROL)
         .build()
         .perform();
    // if you want you can create the array here on this line instead of create inside the method below.
    driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
    //do your wait stuff.
    driver.findElement(By.xpath("//span[contains(@title,'download')]")).click();
    //do your wait stuff.
    driver.close();
    driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(0));
}