// first take each button inside the list 
List<WebElement> myButton = driver.findElements(By.name("submit"));
System.out.println("Size of the button the webpage is : " + myButton.size());
// now you can click button on the basis of index like below

myButton.get(0).click(); // for the first button
//myButton.get(1).click(); // for the second button
//myButton.get(2).click(); // for the third button