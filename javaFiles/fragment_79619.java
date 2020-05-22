@Test
public void testLitianyiNewsIsExisting() throws InterruptedException {
        WebElement inputField = driver.findElement(By.name("q"));
        inputField.sendKeys("selenium");
        inputField.sendKeys(Keys.ENTER);
}