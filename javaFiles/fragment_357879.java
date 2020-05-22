testClass extends BaseClass{
private static String pw = null;

testStudent1(){

   if (pw == null) 
          pw = login.generatePassword();

   driver.findElement(By.xpath(xpathExpression)).sendKeys(pw);

}