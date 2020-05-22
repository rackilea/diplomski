final Map<String,String> lAllKeys = new HashMap<>();
lAllKeys.put("last_name","MARSUPIAL");
lAllKeys.put("first_name", "MARK");
for (String lKey : lAllKeys.keySet()) {
  if (driver.findElements(By.id(lKey)).size() != 0) {  
     driver.findElement(By.id(lKey)).sendKeys(lAllKeys.get(lKey));
  } 
}