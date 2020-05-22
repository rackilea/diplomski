WebElement element = driver.findElement(/* ... */);
try{
element.click();
}catch(SelendroidException ex){
/* your listener for output */
}