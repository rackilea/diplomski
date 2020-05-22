Iterator<Row> rowIterator = sheet.iterator();

 while (rowIterator.hasNext()) {
    Row row = rowIterator.next();

    Iterator<Cell> cellIterator = row.cellIterator();
    while (cellIterator.hasNext()) {
        Cell cell = cellIterator.next();
            cell.getStringCellValue(); //Do something useful with me
...