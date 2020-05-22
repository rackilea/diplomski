List<WebElement> trueResultRows = new ArrayList<WebElement>();
for(WebElement row : resultRows) {
    List<WebElement> rowDataElements = row.findElements(By.tagName("td"));
    for(WebElement rowData : rowDataElements) {
        if("avaiTableHeaderA".equalsIgnoreCase(rowData.getAttribute("class"))){
            trueResultRows.add(row);
            break;
        }
    }
}