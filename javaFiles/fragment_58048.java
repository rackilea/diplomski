public int getNumberOfColumns(int SheetIndex)
{
    int NO_OF_Column=0;HSSFCell cell = null;
    HSSFSheet sheet=null;
            try {
                loadFile();  //load give Excel
                if(validateIndex(SheetIndex))
                {
                    sheet  = workbook.getSheetAt(SheetIndex);
                    Iterator rowIter = sheet.rowIterator();
                    HSSFRow firstRow = (HSSFRow) rowIter.next();
                    Iterator cellIter = firstRow.cellIterator();
                    while(cellIter.hasNext())
                    {
                          cell = (HSSFCell) cellIter.next();
                          NO_OF_Column++;
                    }
                }
                else
                    throw new InvalidSheetIndexException("Invalid sheet index.");
            } catch (Exception ex) {
                logger.error(ex);

            }

    return NO_OF_Column;
}