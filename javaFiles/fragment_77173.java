for (short rowIndex = 0; rowIndex < stringList.length(); rowIndex++) {
    Row row = sheet.createRow(rowIndex);
    String[] cellValues = stringList.get(rowIndex).split("|");
    for (int colIndex = 0; colIndex < cellValues.length; colIndex++) {
        Cell cell = row.createCell(colIndex);
        cell.setCellValue(cellValues[colIndex]);
    }
}