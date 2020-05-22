By identifierXPath = By.xpath("//tr//span[contains(@class,'ng-scope') and contains(text(),'testdt4')]"); 
List<WebElement> list_Cells = driver.findElements(identifierXPath);
System.out.println(list_Cells.size());
for (WebElement single_Cell : list_Cells){
    System.out.println("Cell Text ::-" + single_Cell.getText().trim());
}