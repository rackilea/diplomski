//After click on FLIGHTS...

driver.findElement(By.xpath("//*[@id='flights']/form/div[1]")).click();
Thread.sleep(2*1000);

driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys("Moon");
Thread.sleep(2*1000);