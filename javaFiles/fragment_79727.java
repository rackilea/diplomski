//before any pop ups are open
String parentHandle = driver.getWindowHandle();

//after you have pop ups
for (String popUpHandle : driver.getWindowHandles()) {
  if(!popUpHandle.equals(parentHandle)){
    driver.switchTo().window(popUpHandle);
    if(driver.getCurrentUrl().equalsIgnoreCase(URL of the new window)){
      //do something here
    }
  }
}