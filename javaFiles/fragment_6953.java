driver.findElement(By.xpath("//section[@class='section newSec none']/div//input[@id='empDob']")).clear();
driver.findElement(By.xpath("//section[@class='section newSec none']/div//input[@id='empDob']")).sendKeys(dateTime);

//Wait until date is clickable in datepicker panel

String datexpath = "//th[contains(text(),' "+year+"')]/ancestor::table//td[text()='"+day1[1]+"']";
wait.until(ExpectedConditions.elementToBeClickable(By.xpath(datexpath)));
driver.findElement(By.xpath(datexpath)).click();