HSSFWorkbook workBook = new HSSFWorkbook();
HSSFCellStyle style = workBook.createCellStyle();
style.setFillForegroundColor(HSSFColor.BROWN.index);
style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

HSSFSheet sheet = workBook.createSheet();
int numRow = 20;
int numCol = 20;

for (int rowIndex = 0; rowIndex < numRow; rowIndex++) {
    HSSFRow row = sheet.createRow(rowIndex);
    for (int colIndex = 0; colIndex < numCol; colIndex++) {
        HSSFCell cell = row.createCell(colIndex);
        cell.setCellStyle(brownBG);
    }
}

FileOutputStream fos = new FileOutputStream("test.xls");
workBook.write(fos);
fos.flush();
fos.close();
System.out.println("done");