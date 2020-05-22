WebElement msg=driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/p"));
// Get the text value of an element
String actualTxt = msg.getText();
// Expected [instead of Object expectedText ==> String expected]
String expecteTxt = "";
// Assertion (String, String)
Asserts.assertEquals(actualTxt,expectedTxt);