InputStream inp = new FileInputStream("workbook.xls");
    HSSFWorkbook wb = new HSSFWorkbook(inp);
    Sheet sheet = wb.getSheetAt(0);
    Row row = sheet.getRow(2);
    Cell cell = row.getCell(3);
    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
        System.out.println("string: " + cell.getStringCellValue());
    }
    if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
        System.out.println("numeric: " + cell.getNumericCellValue());
    }
    System.out.println("any: " + cell.toString());