driver.findElement(By.id("input_search")).clear();
driver.findElement(By.id("input_search")).click();

//here write code to wait for sometime around 10-20 seconds

JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
String s = (String) jsExecutor.executeScript("var s1 = 'Search successful'; var s2 = 'Search not successful'; if(document.readyState === 'complete'){return s1;} else {return s2;}");