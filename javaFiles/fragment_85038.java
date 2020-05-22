break;
case Cell.CELL_TYPE_Numeric:
    double x = currentCell.getNumericCellValue();
    //String value = Double.toString(x);
    String value = Long.toString(Math.round(x));
    currentHash.put(HeaderRow.getCell(j).getStringCellValue(), value);
    break;