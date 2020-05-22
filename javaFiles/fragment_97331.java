// Create expected list :: This will contain expected drop-down values
ArrayList expectedDropDownItems = new ArrayList();
expectedDropDownItems.add("Aircel");
expectedDropDownItems.add("Airtel");
expectedDropDownItems.add("BSNL");
expectedDropDownItems.add("Docomo");
expectedDropDownItems.add("Idea");
expectedDropDownItems.add("Reliance");
expectedDropDownItems.add("Vodofone");

// Create a webelement for the drop-down
WebElement serviceProviderDropDownElement = driver.findElement(<locator of the drop-down e.g. By.id, By.xpath etc.>);

// Instantiate Select class with the drop-down webelement
Select serviceProviderDropDown = new Select(serviceProviderDropDownElement);

// Retrieve all drop-down values from the app and store in actual list
List<WebElement> valuesUnderServiceProviderDropDown  = serviceProviderDropDown.getOptions();

ArrayList actualDropDownItems = new ArrayList();

for(WebElement value : valuesUnderServiceProviderDropDown){
    actualDropDownItems.add(value.getText());
}

// Verify Drop-down contains ONLY 7 values
if(valuesUnderServiceProviderDropDown.size()==7)
    System.out.println("Drop-down contain exactly 7 values");

else
    System.out.println("Drop-down doesn't contain exactly 7 values");

// Compare expected and actual list
for (int i = 0; i < actualDropDownItems.size(); i++) {
    if (!expectedDropDownItems.get(i).equals(actualDropDownItems.get(i)))
    System.out.println("Drop-down values are NOT in correct order");
}