public static void main(String[] args) throws Exception{
        FileInputStream fsIP= new FileInputStream(new File("path to your excel file"));
        HSSFWorkbook wb = new HSSFWorkbook(fsIP);
        HSSFSheet worksheet = wb.getSheetAt(0); 
        Cell cell = null;
        cell = worksheet.getRow(2).getCell(2);//get the row and cell value from db
        cell.setCellValue("update the value in excel");                  
        fsIP.close();
        FileOutputStream output_file =new FileOutputStream(new File("path to your excel file"));
        wb.write(output_file);
        output_file.close();
    }