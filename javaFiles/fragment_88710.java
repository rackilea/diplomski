// count number of rows
int sizeRows = driver.findElements(By.xpath("//*[@id='mainData']/table/tbody/tr")).size();

// iterate rows
for(int tableRow = 1; tableRow <= sizeRows; tableRow++) {
   String rowLocator = String.format("//*[@id='mainData']/table/tbody/tr[%d]", tableRow);

   String column1 = driver.findElement(By.xpath(rowLocator+"/td[1]")).getText().trim();
   String column2 = driver.findElement(By.xpath(rowLocator+"/td[2]")).getText().trim();
 ..
 }