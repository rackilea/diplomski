final Workbook wb = new HSSFWorkbook();

final HSSFFont hssfFont = (HSSFFont)wb.createFont();
hssfFont.setBold(true);

final Font font = wb.createFont();
font.setBold(true);