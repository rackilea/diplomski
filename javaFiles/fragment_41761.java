switch (cell.getCellType()) {
    case Cell.CELL_TYPE_STRING:
        str = cell.toString().trim();
        break;
    case Cell.CELL_TYPE_NUMERIC:
        if (DateUtil.isCellDateFormatted(cell)) {
            //you should change this to your application date format
            objSimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            str = objSimpleDateFormat.format(cell.getDateCellValue());
        } else {
            num = cell.getNumericCellValue();
            str = String.valueOf(cell.getNumericCellValue());
        }
        break;
    case Cell.CELL_TYPE_BLANK:
        str = "";
        break;
    case Cell.CELL_TYPE_ERROR:
        str = "";
        break;
    case Cell.CELL_TYPE_BOOLEAN:
        str = String.valueOf(cell.getBooleanCellValue());
    break;
}