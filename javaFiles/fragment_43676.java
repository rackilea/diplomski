Row row = sheet.createRow(currentRow);

CellStyle style = workbook.createCellStyle();
style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
style.setFillPattern(CellStyle.SOLID_FOREGROUND);

Cell cell = row.createCell(0);
cell.setCellValue("ABCDEFG");
cell.setCellStyle(style);