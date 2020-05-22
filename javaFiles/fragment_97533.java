public void StaleElementHandleByID (String elementID){
int count = 0; 
while (count < 4){
    try {
       WebElement yourSlipperyElement= driver.findElement(By.id(elementID));
       yourSlipperyElement.click(); 
     } catch (StaleElementReferenceException e){
       e.toString();
       System.out.println("Trying to recover from a stale element :" + e.getMessage());
       count = count+1;
     }
   count = count+4;
}