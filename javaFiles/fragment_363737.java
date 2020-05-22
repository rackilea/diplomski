import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

BufferedReader in = new BufferedReader(new FileReader("C:\\visualization.txt"));
String line;
line = in.readLine();
in.close();

String[] expectedDropDownItemsInArray = line.split("=")[1].split(",");

// Create expected list :: This will contain expected drop-down values
ArrayList expectedDropDownItems = new ArrayList();
for(int i=0; i<expectedDropDownItemsInArray.length; i++)
    expectedDropDownItems.add(expectedDropDownItemsInArray[i]);

// Create a webelement for the drop-down
WebElement visualizationDropDownElement = driver.findElement(By.id("visualizationId"));

// Instantiate Select class with the drop-down webelement
Select visualizationDropDown = new Select(visualizationDropDownElement);

// Retrieve all drop-down values and store in actual list
List<WebElement> valuesUnderVisualizationDropDown  = visualizationDropDown.getOptions();

List<String> actualDropDownItems = new ArrayList();

for(WebElement value : valuesUnderVisualizationDropDown){
    actualDropDownItems.add(value.getText());
}

// Print expected and actual list
System.out.println("expectedDropDownItems : " +expectedDropDownItems);       
System.out.println("actualDropDownItems : " +actualDropDownItems);

// Verify both the lists having same size
if(actualDropDownItems.size() != expectedDropDownItems.size())
  System.out.println("Property file is NOT updated with the drop-down values");

// Compare expected and actual list
for (int i = 0; i < actualDropDownItems.size(); i++) {
    if (!expectedDropDownItems.get(i).equals(actualDropDownItems.get(i)))
    System.out.println("Drop-down values are NOT in correct order");
}