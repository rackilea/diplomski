int cellType = cell.getCellType();
switch(cellType)
{
    case Cell.CELL_TYPE_BLANK:
          //
          cell.get
          break;
    case Cell.CELL_TYPE_BOOLEAN:
          //
          cellValue = cell.getBooleanCellValue();
          break;
    case Cell.CELL_TYPE_ERROR:
          //
          break;

    case Cell.CELL_TYPE_FORMULA:
          //
          break;
    case Cell.CELL_TYPE_NUMERIC:
          //
          cellValue = cell.getNumericCellValue();
          break;
    case Cell.CELL_TYPE_STRING:
          //
          cellValue = cell.RichStringCellValue();
          break;
}