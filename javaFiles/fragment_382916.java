Workbook wb = WorkbookFactory.create(new File("existing.xls"));
CellStyle origStyle = wb.getCellStyleAt(1); // Or from a cell

Workbook newWB = new XSSFWorkbook();
Sheet sheet = newWB.createSheet();
Row r1 = sheet.createRow(0);
Cell c1 = r1.createCell(0);

CellStyle newStyle = newWB.createCellStyle();
newStyle.cloneStyleFrom(origStyle);
c1.setCellStyle(newStyle);

newWB.write(new FileOutpuStream("new.xlsx"));