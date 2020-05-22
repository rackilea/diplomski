List<WebElement> payDates = driver.findElements(By.xpath("//tr[starts-with(@id,'changeStartWeekGrid_row_')]/td[contains(@id,'_cell_4')/span]"));

int reqIndex = 0;

for(WebElement pd;payDates) {

//Use class java.time.LocalDate to do the parsing andcomparison with current date.
if (condition satisfied) 
     break
else
     reqIndex++;
}

driver.findElement(By.xpath("//tr[@id='changeStartWeekGrid_row_'" + reqIndex +"]")/path to radio button).click()