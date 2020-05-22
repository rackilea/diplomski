//this will click three days before
Date today = new Date();
Date minusThree = new Date();
Calendar now = Calendar.getInstance();
now.setTime(today);
Calendar before = Calendar.getInstance();
before.setTime(minusThree);
before.add(Calendar.DAY_OF_YEAR, -3);
int monthNow = now.get(Calendar.MONTH);
int monthBefore = before.get(Calendar.MONTH);

if (monthBefore < monthNow){
  // click previous month in the calendar tooltip on page
}
WebElement dateToSelect = driver.findElement(By.xpath("//span[text()='"+threeDaysBefore()+"']"));
dateToSelect.click();