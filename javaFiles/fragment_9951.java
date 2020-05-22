Row row = (XSSFRow) rows.next();
    int rowcellnum = row.getLastCellNum();
    for (int cn = 0; cn < rowcellnum; cn++) {
        String cellVal = "";
        Cell cell = row.getCell(cn);
        if (cell == null) {
            //HANDLE NULL
        }
        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
            System.out.print(cell.getStringCellValue() + " ");
        } else if (cell.getCellType() ==  XSSFCell.CELL_TYPE_NUMERIC) {
                        System.out.print(cell.getNumericCellValue() + " ");
        } else {
        }
    }