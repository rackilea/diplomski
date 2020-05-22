driver.findElement(By.id("input_search")).clear();
driver.findElement(By.id("input_search")).click();

//here write code to wait for an element available on search result page

try{
if(driver.findElement(By.id("search result page element")).isDisplayed() == true){
System.out.println("Search successful");
} catch (NoSuchElementFound ee){System.out.println("Search not successful");}