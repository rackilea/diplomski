FileInputStream excelFile = new FileInputStream(new File(Excel_FilePath));
Workbook excelWorkbook = new XSSFWorkbook(excelFile);
Sheet datatypeSheet = excelWorkbook.getSheetAt(0); //This will get you first sheet     from workbook
Iterator<Row> iterator = datatypeSheet.iterator();
Row firstRow = iterator.next();
while (iterator.hasNext()) {
    Row currentRow = iterator.next();
    int currentRowNumberOfColumns = currentRow.getPhysicalNumberOfCells();
}