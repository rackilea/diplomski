for(int i=1; i<=sheet.getLastRowNum(); i++){
    try{
        row = sheet.getRow(i);
        pst.setString(1, row.getCell(0).getStringCellValue());
        pst.setInt(2, row.getCell(1).getNumericCellValue());
        pst.setString(3, row.getCell(2).getStringCellValue());
        pst.setInt(4, row.getCell(3).getNumericCellValue());
        pst.setString(5, row.getCell(4).getStringCellValue());
        pst.execute();
    } catch(NumberFormatException e){
          e.printStackTrace();
    }
}