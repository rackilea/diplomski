String selectorString = "a.some-text.item";
driver.findElement(By.cssSelector(selectorString)).click();

//Now verify element clicked or not 
WebElement we = driver.findElement(By.cssSelector(selectorString));
String msg =  (we.getAttribute("class").contains("clicked")) ? "element clicked" : "element not clicked";
System.out.println(msg);