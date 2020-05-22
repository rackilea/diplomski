List<WebElement> fullNames = driver.findELements(By.cssSelector("ul.displayAddressUL li.AddressFullName>b"));
List<WebElement> addressLines= driver.findELements(By.cssSelector("ul.displayAddressUL li.AddressAddressLine"));
List<WebElement> cities= driver.findELements(By.cssSelector("ul.displayAddressUL li.AddressCity"));
List<WebElement> countries=driver.findELements(By.cssSelector("ul.displayAddressUL li.country"));
List<WebElement> phoneNums=driver.findELements(By.cssSelector("ul.displayAddressUL li.phone"));

for (int i=0;i<fullNames.size(); i++){
String fullName= fullNames.get(i).getText();
String addressLine =addressLines.get(i).getText();
String city = cities.get(i).getText();
String county = countries.get(i).getText();
String phoneNumber = phoneNums.get(i).getText();
}