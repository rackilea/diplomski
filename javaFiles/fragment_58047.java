public void ExcelTOCSV(){
    CSVWriter writer=null;
    int columnLength =0;
    int i =0;String[] rowData;
    HSSFCell cell = null;HSSFSheet sheet=null;
    int SheetIndex=0;
    try
    {
        InputStream  resourceAsStream =ClassLoader.getSystemResourceAsStream(filePath);
        HSSFWorkbook workbook = new HSSFWorkbook(resourceAsStream);
        sheet = workbook.getSheetAt(sheetIndex);

        //Here i am create my custom method to get column row on the basis of Sheet index. 
        columnLength = getNumberOfColumns(sheetIndex);
        writer = new CSVWriter(new FileWriter("c:\\yourfile.csv"));
        Iterator<Row> rows = sheet.rowIterator();
        while (rows.hasNext())
        {
                rowData=new String[columnLength];
                HSSFRow row = (HSSFRow) rows.next();
                Iterator<Cell> cells = row.cellIterator();
                i = 0;
                        while (cells.hasNext())
                        {
                            cell = (HSSFCell) cells.next();
                            //Must do this, you need to get value based on the cell type
                                                switch (cell.getCellType())
                                                {
                                                    case HSSFCell.CELL_TYPE_NUMERIC:
                                                       rowData[i]=Double.toString(cell.getNumericCellValue());
                                                    break;

                                                    case HSSFCell.CELL_TYPE_STRING:
                                                         rowData[i]=cell.getStringCellValue();
                                                       break;

                                                    case HSSFCell.CELL_TYPE_BLANK:

                                                       break;

                                                    default: break;
                                                }//end of switch
                                   i++;
                                }//cell while loop
                 writer.writeNext(rowData);//writing data into file
            }//Row While loop
             writer.close();

    } 
    catch (IOException ex)
    {
        Logger.getLogger(CreateCSVFile.class.getName()).log(Level.SEVERE, null, ex);
    }
}