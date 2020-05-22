public static Object[][] TestData() {
    sheet = book.getSheetAt(0);
    int rowCount = sheet.getLastRowNum();
    int cellCount = sheet.getRow(0).getLastCellNum();
    Object[][] data = new Object[rowCount][cellCount];
    for (int i = 0; i < rowCount; i++) {
        for (int j = 0; j < cellCount; j++) {
            switch (sheet.getRow(1).getCell(j).getCellType()) {
               case Cell.CELL_TYPE_NUMERIC:
                   // Call 'getNumericCellValue()' here instead of using just 'getCell()'
                   data[i][j] = sheet.getRow(1).getCell(j).getNumericCellValue();
                   break;
               case Cell.CELL_TYPE_STRING:
                   // Call 'getStringCellValue()' here instead of using just 'getCell()'
                   data[i][j] = sheet.getRow(1).getCell(j).getStringCellValue().trim();
                   break;
            }
        }
    }
    return data;
}