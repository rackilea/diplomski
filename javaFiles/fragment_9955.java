String date1 = "28";
 String date2 = "06";
 String date3 = "1985";

  waitForElementPresent(By.id(bla));
  driver.findElement(By.id(bla)).click();
  driver.findElement(By.id(bla)).clear();
  driver.findElement(By.id(bla)).sendKeys(date1);
  driver.findElement(By.id(bla)).sendKeys(date2);
  driver.findElement(By.id(bla)).sendKeys(date3);
  driver.findElement(By.id(Submitbutton).click()