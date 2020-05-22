@Test
public void test() {
    WebElement Webtable=driver.findElement(By.id("TableID")); // Replace TableID with Actual Table ID or Xpath

    List<WebElement> TotalRowCount=Webtable.findElements(By.xpath("//*[@id='TableID']/tbody/tr"));

    System.out.println("No. of Rows in the WebTable: "+TotalRowCount.size());
    // Now we will Iterate the Table and print the Values   

    int RowIndex=1;

    for(WebElement rowElement:TotalRowCount)
    {
        List<WebElement> TotalColumnCount=rowElement.findElements(By.xpath("td"));
        int ColumnIndex=1;

        for(WebElement colElement:TotalColumnCount)
        {
            System.out.println("Row "+RowIndex+" Column "+ColumnIndex+" Data "+colElement.getText());
            ColumnIndex=ColumnIndex+1;
        }
        RowIndex=RowIndex+1;
    }
}