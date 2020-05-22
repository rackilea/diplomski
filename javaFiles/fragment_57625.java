[![List<WebElement> rows = driver.findElements(By.xpath("//*[contains(@class,'ui-grid-cell ng-scope ui-grid-disable-selection ui-grid-coluiGrid-0006')]//div"));
    int iSize = rows.size();
for (int i = 0; i < iSize; i++) {
                String sValue =  "192.168.30.70";
                if (sValue.equalsIgnoreCase(inputtext)) {
                    rows.get(i).click();
                    break;
                }
            }