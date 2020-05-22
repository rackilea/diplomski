WebElement resultTable = null;
for(WebElement table : allTables) {
    if("table-1".equalsIgnoreCase(table.getAttribute("id")){
        continue;
    }
    resultTable = table;
    break;
}