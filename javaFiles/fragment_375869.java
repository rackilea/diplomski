for(String value : line)
{
    Cell cell = row.createCell(cell_num++);
    cell.setCellValue(new Double(value));
    cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
}