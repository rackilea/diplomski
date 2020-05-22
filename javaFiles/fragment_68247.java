String rowsXpath = "id('CollectorQoSPerformanceMetricsgrid')//div[contains(@class, 'x-grid3-row x-unselectable-single')]";
List<WebElement> rows = driver.findElements(By.xpath(rowsXpath));
boolean foundCollector = false;
for(WebElement row : rows) {
    if(!row.findElements(By.xpath(".//u[text()='" + collector + "']")).isEmpty()) {
        foundCollector = true;
        break;
    }
}