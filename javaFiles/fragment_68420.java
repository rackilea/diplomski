File src = new File("C:\\Users\\xyz\\Desktop\\folder\\file.xlsx");
    FileInputStream file = new FileInputStream(src);
    Workbook workbook = new XSSFWorkbook(file);
    Sheet sheet1 = workbook.getSheetAt(0);
    int rows = sheet1.getPhysicalNumberOfRows();
    workbook.createSheet();
    Sheet sheet2 = workbook.getSheetAt(1);
    Row sheet2FirstRow = sheet2.createRow(0);
    for (int Readingrowindex = 1; Readingrowindex < rows; Readingrowindex++) {

        String ah = sheet1.getRow(Readingrowindex).getCell(1).getStringCellValue();
        sheet2.createRow(Readingrowindex).createCell(0).setCellValue(ah);
        Cell cell = sheet2FirstRow.createCell(Readingrowindex);
        cell.setCellValue((String) ah);

    }

    FileOutputStream fout = new FileOutputStream(src);
    workbook.write(fout);