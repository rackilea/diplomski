public static void getAllColumnFromRow(HSSFRow RowObject){
    Iterator<Cell> itr = RowObject.iterator();
    HSSFRow headerRow = RowObject.getSheet().getRow(0);
    String cellValue = "";
    String information = "";
    int headerCellCount = 0;
    //to avoid first column
    itr.next();

    while(itr.hasNext()){
        Cell cell = itr.next();
        Cell headerValue = headerRow.getCell(headerCellCount++);
        switch(cell.getCellType()) {
        case HSSFCell.CELL_TYPE_BOOLEAN:
            cellValue = cell.getBooleanCellValue() +"";
            information = information + " " +headerValue+" - "+cellValue+ "; ";
            break;
        case HSSFCell.CELL_TYPE_NUMERIC:
            cellValue = cell.getNumericCellValue() + "";
            information = information + " " +headerValue+" - "+cellValue+ "; ";
            break;
        case HSSFCell.CELL_TYPE_STRING:
            cellValue = cell.getStringCellValue();
            information = information + " " +headerValue+" - "+cellValue+ "; ";
            break;
        case HSSFCell.CELL_TYPE_BLANK:
            break;
        }
    }
    System.out.println(information);
}