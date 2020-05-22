//Get the existing excel file
  Workbook file=Workbook.getWorkbook(new File("test.xls"));
//Open a copy of the excel file,and specify the parameters to write the data back
//to the original file.
  WritableWorkbook writeBook=Workbook.createWorkbook(new File("test.xls"),file);
  writeBook.removeSheet(0);