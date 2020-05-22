@Test
public void testClaimsTestToCalcNode() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("becsStartCalculator")).click();
    driver.findElement(By.id("MARITAL_STATUS_false")).click();
    driver.findElement(By.id("btn_next")).click();
    driver.findElement(By.id("HOME_ABROAD_false")).click();

    *** This is where the null pointer is ***
    *******************************
    screenshot.takeScreenshot(driver);
    *******************************


    driver.findElement(By.id("btn_next")).click();
    driver.findElement(By.id("DETAILS_STUDENT_YOU_false")).click();