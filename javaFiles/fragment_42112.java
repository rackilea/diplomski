for (....) {
    try {
        String accountName=getTableData(By.xPath(".//*[@id='accTable']/"), rowNo, colNo);
        accountList.add(accountName);
    } catch (NoSuchElementException ex) {
        //Do nothing
    }
}