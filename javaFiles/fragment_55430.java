int r = 0;
int c = 0;
int maxCellsPerRow = 10;
Row row = sheet.createRow(r);
for (String str : data)
{
    Cell cell = row.createCell(c);
    cell.setCellValue(str);

    c++;
    // Create and advance to next row if needed.
    if (c >= maxCellsPerRow)
    {
       c = 0;
       r++;
       row = sheet.createRow(r);
    }
}