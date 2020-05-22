@Test
public void Login()  {
    String UserName = ex.getExcelValue(scenarioName, 2, 4);
    cd.findElement(By.xpath("//body/center/form/table/tbody/tr/td/div/div[2]/table/tbody/tr[1]/td[2]/input")).sendKeys(UserName);
    String PassWord = ex.getExcelValue(scenarioName, 3, 4);
    cd.findElement(By.xpath("//body/center/form/table/tbody/tr/td/div/div[2]/table/tbody/tr[2]/td[2]/input")).sendKeys(PassWord);
    cd.findElement(By.xpath("//body/center/form/table/tbody/tr/td/div/div[2]/table/tbody/tr[3]/td[2]/input")).click();
    cd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    String ExpTitle = "Demo Practice";
    String ActTitle = cd.getTitle();
    ex.setExcelValue(scenarioName, 2, 8, "FAILED");
    assertEquals(ActTitle, ExpTitle, "Expected: "+ExpTitle+" but found: "+ActTitle);
    ex.setExcelValue(scenarioName, 2, 8, "PASSED");

}