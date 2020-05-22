AreaReference aref = new AreaReference(sheet.getSheetName() + "!A3:A9", SpreadsheetVersion.EXCEL2007);
CellReference[] crefs = aref.getAllReferencedCells();
for (int i=0; i<crefs.length; i++) {
    XSSFSheet s = workbook.getSheet(crefs[i].getSheetName());
    Row r = s.getRow(crefs[i].getRow());
    Cell c = r.getCell(crefs[i].getCol());
}