List<WebElement> NomDOBYear =  driver.findElements(By.className("ui-datepicker- 
year"));
Select selectYear= new Select(NomDOBYear.get(0));//first element of the list
selectYear.selectByVisibleText("1991");


WebElement NomDOBMonth = driver.findElement(By.className("ui- 
datepicker-month"));// you got the class name wrong here
Select selectMonth= new Select(NomDOBMonth);
selectMonth.selectByVisibleText("Nov");