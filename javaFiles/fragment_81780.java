import org.apache.poi.ss.usermodel.DataFormatter;

FileInputStream fis = new FileInputStream(workbookName);
Workbook workbook = WorkbookFactory.create(fis);
Sheet sheet = workbook.getSheet(sheetName);
DataFormatter formatter = new DataFormatter();
String val = formatter.formatCellValue(sheet.getRow(row).getCell(col));
list.add(val);   //Adding value to list