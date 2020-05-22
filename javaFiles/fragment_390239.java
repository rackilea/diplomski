driver.findElement(By.id("txtOnwardCalendar")).click();
WebElement selectElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("monthTable first")));
Select select = new Select(selectElement);
select.selectByValue("2012");
Thread.sleep(6000);
WebElement dateWidget = driver.findElement(By.id("monthTitle"));
List<WebElement> columns011=dateWidget011.findElements(By.tagName("td"));
for (WebElement cell: columns011){
//Select  Month
if (cell.getText().equals("Feb")){
cell.findElement(By.linkText("Feb")).click();
break;
}
}