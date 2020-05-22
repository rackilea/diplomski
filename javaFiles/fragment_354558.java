long start = System.currentTimeMillis();

driver.get("Some url");

WebElement ele = driver.findElement(By.id("ID of some element on the page which will load"));
long finish = System.currentTimeMillis();
long totalTime = finish - start; 
System.out.println("Total Time for page load - "+totalTime);