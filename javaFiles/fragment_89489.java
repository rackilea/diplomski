while(rowIterator.hasNext()) {
    Row row = rowIterator.next();
    String RowContent = null;
    Iterator<Cell> cellIterator = row.cellIterator();
    while(cellIterator.hasNext()) {
        Cell cell = cellIterator.next();
        RowContent=RowContent+cell.toString();
    }
    //Code for saving RowContent or printing or whatever you want for text in complete row
}