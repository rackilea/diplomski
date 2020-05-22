driver.switchTo.frame("id"); //using the frame id attribute
// or
driver.switchTo.frame("name"); //using the frame name attribute
// or
WebElement frame = driver.findElement(...);
driver.switchTo.frame(frame); //using the frame as WebElement