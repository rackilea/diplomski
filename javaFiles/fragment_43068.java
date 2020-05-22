WritableWorkbook workbook = Workbook.createWorkbook(new File("D:\\output.xls"));
    WritableSheet sheet = workbook.createSheet("First Sheet", 0);
    Label label = new Label(0, 2, "A label record"); 
    sheet.addCell(label);
    workbook.write(); 
    workbook.close();

    //MODIFY XLS

    Workbook workbook1 = Workbook.getWorkbook(new File("D:\\output.xls"));
    WritableWorkbook copy = Workbook.createWorkbook(new File("D:\\output.xls"), workbook1);
    WritableSheet sheet2 = copy.getSheet(0); 
    //WritableCell cell = sheet2.getWritableCell(5, 2); 

    copy.write();
    copy.close();