Row row = sheet.createRow(0);

CellStyle style = workbook.createCellStyle();
  style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
  style.setFillPattern(CellStyle.SOLID_FOREGROUND);

for(RiskVo h : selectedExcel){
    row.createCell(h.getIndex()).setCellValue(h.getRisk_disc_en());
    row.getCell(h.getIndex()).setCellStyle(style);
}