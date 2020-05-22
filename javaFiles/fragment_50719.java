try{
if(driver.findElement(By.id("DROPDOWN")).isDisplayed()){

                driver.findElement(By.id("DROPDOWN")).click();
                driver.findElement(By.xpath("Choice in Drop DOWN)).click();
                driver.findElement(By.id("CheckBox")).click();  
     }
catch (NoSuchElementException e)
{
// I believe you dont have to do anything here. May be a console log will do.
}