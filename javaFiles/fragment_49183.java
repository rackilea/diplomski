public  void setData(String adr,String sht,int rn,int cn,String val) throws Exception{

    FileInputStream fsIP= new FileInputStream(new File(adr)); //Read the spreadsheet that needs to be updated

    XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook

    XSSFSheet worksheet = wb.getSheet(sht); //Access the worksheet, so that we can update / modify it.

    Cell cell = null; // declare a Cell object

    cell = worksheet.getRow(rn).getCell(cn);   // Access the second cell in second row to update the value

    cell.setCellValue(val);  // Get current cell value value and overwrite the value

    fsIP.close(); //Close the InputStream

    FileOutputStream output_file =new FileOutputStream(new File(adr));  //Open FileOutputStream to write updates

    wb.write(output_file); //write changes

    output_file.close();  //close the stream   
}