//find all the links of sibling(s) of the 'Test Pages' 
List<WebElement> drop_downs= driver.findElements(By.xpath("//*[contains(text(), 'Test Pages')]/following-sibling::*//a"));

for(WebElement links : drop_downs){
     System.out.println(links.getAttribute("innerHTML"));
}