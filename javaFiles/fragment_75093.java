XSSFWorkbook wb = new XSSFWorkbook(new File("MyExcel.xls"));
XSSFSheet sheet = wb.getSheetAt(0);
DataFormatter formatter = new DataFormatter();
for (Iterator iterator = sheet.rowIterator(); iterator.hasNext();) {
    XSSFRow row = (XSSFRow) iterator.next();
    for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
        XSSFCell cell = row.getCell(i);
        System.out.println(formatter .formatCellValue(cell));
    }

}