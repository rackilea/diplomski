SXSSFRow row = null;
String[] colValues = null;

CellStyle style = workbook.createCellStyle();
style.setAlignment(XSSFCellStyle.ALIGN_RIGHT);

for (int i = 1 ; i<= rowList.size() ; i++) {
    row = (SXSSFRow) worksheet.createRow(rowCount);