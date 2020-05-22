List<WebElement> list = webDriver.findElements(By.xpath(expression));
int listcount = list.size();    
List optionsList = null;
String options[] = new String[listcount];

for (int i=1; i<=listcount; i++) 
{                     
    options[i-1] = webDriver.findElement(By.xpath("expression")).getText();
    //contains three words eg: Test Engineer Madhu               
    String[] expectedOptions = options[i-1].split(" ");
    //splitting based on the space           
    // I hope the next line gives you the correct lastName
    String lastName =expectedOptions[expectedOptions.length-1]; 
    // lets store the last name in the array
    options[i-1] = lastName;        
 }         
 optionsList = Arrays.asList(options);
 // Iterate through the list to see all last names.