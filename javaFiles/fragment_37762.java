public String getValue(int x, int y){
    Row row = this.activeSheet.getRow(y);
    if(row==null) return "";
    Cell cell = row.getCell(x);
    if(cell==null) return "";
    int type = cell.getCellType();
    switch(type){
    case 0:
        return cell.getNumericCellValue() + "";
    case 1:
        return cell.getStringCellValue();
    case 2:
        return cell.getCellFormula();
    case 3:
        return "";
    case 4:
        return cell.getBooleanCellValue() + "";
    case 5:
        return cell.getErrorCellValue() + "";
    default:
        return "";
    }
}