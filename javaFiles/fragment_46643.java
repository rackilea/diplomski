File excel = new File("/tmp/result.xls");

    //Open existing Excel file:
    Workbook wb = WorkbookFactory.create(excel);

    //Create a new Excel file:
    //Workbook wb = new HSSFWorkbook();

    //Read in CSV
    String name = "test";
    Sheet sheet = wb.getSheet(name);
    if (sheet == null) {
        sheet = wb.createSheet(name);
    }

    int rowCount = 0;
    Scanner scanner = new Scanner(new File("/tmp/" + name + ".csv"));
    while (scanner.hasNextLine()) {
        String[] rowData = scanner.nextLine().split(",");
        for (int col = 0; col < rowData.length; col++) {
            Row row = sheet.getRow(rowCount);
            if (row == null)
                row = sheet.createRow(rowCount);
            Cell cell = row.getCell(col);
            if (cell == null) {
                cell = row.createCell(col);
            }
            cell.setCellValue(rowData[col]);
        }
        rowCount++;
    }

    wb.write(new FileOutputStream(excel));
}