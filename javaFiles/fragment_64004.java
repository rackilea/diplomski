XSSFSheet ws = wb.getSheet("Sheet1");
CellReference cellReference = new CellReference("A11");
XSSFRow row = sheet.getRow(cellReference.getRow());
if (row != null) {
    XSSFCell cell = row.getCell(cellReference.getCol());
}