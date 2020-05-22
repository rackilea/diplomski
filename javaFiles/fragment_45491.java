...
    Sheet sh = wb.getSheet("sheet1");
    if (sh == null) sh = wb.createSheet("sheet1");
    Row r = sh.getRow(row1);
    if (r == null) r = sh.createRow(row1);
    Cell c = r.createCell(cell1);
    c.setCellValue(message);
...