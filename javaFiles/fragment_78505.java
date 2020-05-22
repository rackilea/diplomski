private int createHierarchy(Sheet sheet, Node node, int currentRowIdx, int nodeLevel) {
    if(node.getParent() == null){
        sheet.setColumnWidth(8, 1000);
        Row row = sheet.createRow(currentRowIdx);
        row.createCell(nodeLevel).setCellValue(node.getName());
        row.createCell(9).setCellValue(node.getValue());
        sheet.addMergedRegion(new CellRangeAddress(currentRowIdx, currentRowIdx, nodeLevel, 8));
        nodeLevel++;
    }

    for (Node node : node.getChildren()) {
        Row row = sheet.createRow(++currentRowIdx);
        row.createCell(nodeLevel).setCellValue(node.getName());
        row.createCell(9).setCellValue(node.getValue());
        sheet.addMergedRegion(new CellRangeAddress(currentRowIdx, currentRowIdx, nodeLevel, 8));
        currentRowIdx = createHierarchy(sheet, node, currentRowIdx, nodeLevel+1);
    }

    return currentRowIdx;
}