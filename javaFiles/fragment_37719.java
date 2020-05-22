WebElement NomDOBYear =  driver.findElement(By.className("ui-datepicker-year"));
Select selectYear= new Select(NomDOBYear);
selectYear.selectByVisibleText("1991");


WebElement NomDOBMonth = driver.findElement(By.className("ui-datepicker-month"));
Select selectMonth= new Select(NomDOBMonth);
selectMonth.selectByVisibleText("Nov");