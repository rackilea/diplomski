for(String value : line)
{
    Cell cell = row.createCell(cell_num++);
    try
    {
        cell.setCellValue(new Double(value));
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
    }
    catch(Exception ex)
    {
        cell.setCellValue(value);
    }
}