Never Mind Folks.
[This link ][1] helps me to resolve the issue. Just added line to focus on next element **driver.findElement(By.id("ArrivalTime")).sendKeys(Keys.TAB);**

**The Update Code:**

driver.findElement(By.id("DeparturePoint")).sendKeys("New York");
driver.findElement(By.id("ArrivalPoint")).sendKeys("Paris");
driver.findElement(By.id("DepartureTime")).sendKeys("12:01 am");   
driver.findElement(By.id("ArrivalTime")).sendKeys("12:01 am");
Thread.sleep(1000); 
driver.findElement(By.id("ArrivalTime")).sendKeys(Keys.TAB);
driver.findElement(By.id("DepartureDate")).sendKeys("07/10/2016");  
driver.findElement(By.id("ArrivalDate")).sendKeys("07/16/2016");
Thread.sleep(1000); 
driver.findElement(By.id("ArrivalTime")).sendKeys(Keys.TAB);
  [1]: http://www.guru99.com/handling-date-time-picker-using-selenium.html