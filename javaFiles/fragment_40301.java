public WritableWorkbook writeDataInCell(int col,int row,String result,WritableWorkbook book1)     throws RowsExceededException, WriteException, BiffException, IOException
    {
    WritableSheet firstSheet = book1.getSheet(0);

    Label label= new Label(col, row, result);

    firstSheet.addCell(label);

    System.out.println("writeDataInCell method executed for row-> "+row);
return book1;
    }