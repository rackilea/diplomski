public TableElements getTableElements() throws Exception {
    if (getColumnsList()!=null) {

        List<WebElement> elements = getColumnsList();
        List<String> columnNames = new ArrayList<>();
        List<String> rowValues = new ArrayList<>();
        ListIterator<WebElement> listItr = null;
        int columnsNumber = elements.size();
        System.out.println("columnsNumber is: " + columnsNumber + " in " + driver.findElement(By.xpath(datasource)).getText());
        WebElement cell = driver.findElement(By.xpath(getValue("firstColumnXpath")));
        cell.click();
        listItr = elements.listIterator();
        while (listItr.hasNext()) {
            columnNames.add(listItr.next().getText());
            rowValues.add(driver.switchTo().activeElement().getText());
        driver.switchTo().activeElement().sendKeys(Keys.ARROW_RIGHT);
        }
        return new TableElements(columnNames, rowValues);
    }
    else {
        return new TableElements(null, null);
    }
}

public List<WebElement> getColumnsList() throws Exception {
    if (CSSElementExists(getValue("columnLabelsCSS")))
        return driver.findElements(By.xpath(getValue("columnLabelsXpath")));
    return null;
}