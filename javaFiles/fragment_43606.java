WebElement btnSubmit = drvier.findElement(By.id("submit"));
btnSubmit.click();

WebElement txtTest = drvier.findElement(By.id("txtTest"));
string color = txtTest.getCssValue("background-color");
// color should be "orange" in this case