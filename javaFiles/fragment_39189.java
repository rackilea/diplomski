DataFormatter fmt = new DataFormatter();
String divi = fmt.formatCellValue(row.getCell(27).getNumericCellValue());
if (divi.length() > 2) {
   throw new IllegalStateException("Row should contain a 2 digit number, found " + divi);
}
bean.setDIVI(divi);