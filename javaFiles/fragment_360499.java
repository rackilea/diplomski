void collapseRows(Integer level) {
    System.out.println("Collapse Level: " + level);

    XSSFSheet dataSheet = (XSSFSheet) pivotTable.getDataSheet();
    Set<String> colAValues = new LinkedHashSet<String>();

    for (Integer r = 1; r < dataSheet.getLastRowNum() + 1; r++) {
        Row row = dataSheet.getRow(r);
        if (row != null) {
            Cell cell = row.getCell(level);
            if (cell != null) {
                colAValues.add(cell.toString());
            }
        }
    }

    List<org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItem> itemList =
        pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(level).getItems().getItemList();
    Integer i = 0;
    org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItem item = null;

    for (String value : colAValues) {
        item = itemList.get(i);
        item.unsetT();
        item.setX(i++);
        pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields()
            .getCacheFieldArray(level).getSharedItems().addNewS().setV(value);
        item.setSd(false); // set False will collapse child item
    }

    while (i < itemList.size()) {
        item = itemList.get(i++);
        item.setSd(false); // set False will collapse row
    }
}