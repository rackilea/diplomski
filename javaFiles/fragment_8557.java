Workbook wb = WorkbookFactory.create(new FileInputStream("file.xls"));
    Sheet sheet = wb.getSheetAt(0);

    for (int j=0; j< sheet.getLastRowNum() + 1; j++) {
        Row row = sheet.getRow(j);
        Cell cell = row.getCell(0); //get first cell
        // Printing Stuff
    }