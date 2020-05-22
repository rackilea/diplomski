// get the workbook Data
Workbook wbRES = new HSSFWorkbook(new FileInputStream("C:\\input.xls"));
Workbook wbML = new HSSFWorkbook(new FileInputStream("C:\\output.xls"));
// get the sheet from Output
Sheet sheetRESEARCH = wbRES.getSheet("Data");
Sheet sheetML = wbML.getSheet("Output");

try
{
    // initialize variables
    int iRowCountDataRES = 1;
    Cell cPostDateRES = null;
    Cell cPostDateML = null;
    Row rPostDateRES;
    Row rPostDateML;

    // loop thru every row of data in Data Sheet
    while (sheetRESEARCH.getRow(iRowCountDataRES) != null)
    {
        //set the cell location in Data Sheet
        rPostDateRES = sheetRESEARCH.getRow(iRowCountDataRES);
        cPostDateRES = rPostDateRES.getCell(0);

        //set the cell location in Output Sheet
        rPostDateML = sheetML.createRow(iRowCountDataRES);
        cPostDateML = rPostDateML.createCell(0);

        //transfer data to Output Sheet
        cPostDateML.setCellValue(cPostDateRES.getRichStringCellValue().toString());

        //print cell value
        System.out.println(cPostDateRES.getRichStringCellValue().toString());
        //cPostDateRES.getRichStringCellValue().toString();

        //increment row value
        iRowCountDataRES = iRowCountDataRES + 1;
    }
    //add this line and do a proper exception handling and Close the OutputStream and workbooks in a finally block
    wbML.write( new FileOutputStream("C:\\output.xls"));
}

catch(Exception e)
{

    e.printStackTrace();
}
wbML.close();
wbRES.close();