File excelFile = new File("D:\\Excel file\\data.xlsx");
Workbook workBook = WorkbookFactory.create(excelFile);
Sheet sheet = workBook.getSheet("Daily");
DataFormatter formatter = new DataFormatter();

// Start from the 2nd row, processing all to the end
// Note - Rows and Columns in Apache POI are 0-based not 1-based
for (int rn=1; rn<=sheet.getLastRowNum(); rn++) {
   Row row = sheet.getRow(rn);
   if (row == null) {
      // Whole row is empty. Handle as required here
      continue;
   }
   List<String> values = new ArrayList<String>();
   for (int cn=6; cn<35; cn++) {
      Cell cell = row.getCell(cn);
      String val = null;
      if (cell != null) { val = formatter.formatCellValue(cell); }
      if (val == null || val.isEmpty()) {
         // Cell is empty. Handle as required here
      }
      // Save the value to list. Save to an object instead if required
      values.append(val);
   }
}
workBook.close();