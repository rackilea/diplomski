WebElement ele= driver.findElement(By.id("sim-switch"));
 if(ele.isSelected()==true)
 {
     System.out.println("it is clicked");
     //append your operations
 }
 else
 {
     ele.click();
     System.out.println("it is now clicked");
     //append your operations
 }