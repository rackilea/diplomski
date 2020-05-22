@Test
public void testLoginFormExists() {
    WebElement login = driver.findElement(By.id("username"));
    WebElement password = driver.findElement(By.id("password"));
    ...
}