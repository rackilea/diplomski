for (int i=1;i<rows;i++){
    try{
        Row row = sheet.getRow(i);
        Cell cell = row.getCell(2); // Here is the NullPointerException
        String cellString = cell.getStringCellValue();
        myArrayList.add(cellString);
    }catch(NullPointerException NPE)
    {
        //what to do when the exception occurs?
    }
}