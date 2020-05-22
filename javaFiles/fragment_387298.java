WebElement defaultItem = driver.findElement(By.xpath("//*[@id='myAddNewCampaignForm']/ol/li[16]/select"));
Select select = new Select(defaultItem);
List<WebElement> selectedOptions = select.getAllSelectedOptions();


for(WebElement option : selectedOptions){
   System.out.println(option.getText());
}