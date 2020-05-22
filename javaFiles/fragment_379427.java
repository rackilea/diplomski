Workbook workbook = new XSSFWorkbook();  // OR new HSSFWorkbook()
Sheet sheet = workbook.createSheet("Sheet1");
Map<String, Object> properties = new HashMap<String, Object>();

// create your spreadsheet without borders
...

// create property set for vertical borders
properties.put(CellUtil.BORDER_LEFT, CellStyle.BORDER_MEDIUM);
properties.put(CellUtil.BORDER_RIGHT, CellStyle.BORDER_MEDIUM);

// Apply the borders to a 3x3 region starting at D4
for (int ix=3; ix <= 5; ix++) {
  row = sheet.createRow(ix);
  for (int iy = 3; iy <= 5; iy++) {
    cell = row.createCell(iy);
    CellUtil.setCellStyleProperties(cell, properties);
  }
}