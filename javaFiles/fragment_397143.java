int numRows = selenium.getXpathCount("table[@id='myTable']//tbody//" + 
        "tr[not(@style)]/td[1]").intValue();
String[] values = new String[numRows];
for (int i = 0; i < numRows; i++) {
    values[i] = selenium.getText("table[@id='myTable']//tbody//" +
            "tr[not(@style)][" + i + "]/td[1]");
}