String founded = "";

List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Founded')]//following::dd[1]"));

if(list.isEmpty() || list.get(0).getText() == null || list.get(0).getText().isEmpty())
 {
   founded = "NA";
 }else {
   founded = list.get(0).getText();
 }    
 System.out.println(founded);