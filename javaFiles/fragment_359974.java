public static void differentFontTypeInSameCell(){
    Workbook wb = new HSSFWorkbook();
    Sheet sheet = wb.createSheet("TestSheet");
    Cell cell = sheet.createRow(0).createCell(0);
    Font underlineFont = wb.createFont();
    underlineFont.setUnderline(HSSFFont.U_DOUBLE);
    Font boldFont = wb.createFont();
    boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
    Font italicFont = wb.createFont();
    italicFont.setItalic(true);
    CellStyle style = wb.createCellStyle();
    style.setFont(underlineFont);
    cell.setCellStyle(style);
    RichTextString richString = new HSSFRichTextString("Underline, Bold, Italic");
    richString.applyFont(11, 15, boldFont);
    richString.applyFont(17, 23, italicFont);
    cell.setCellValue(richString);
}