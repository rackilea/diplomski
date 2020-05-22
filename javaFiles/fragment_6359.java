File file = new File("Main Data.xlsx");
    // Retrieve the workbook for the main report
    XSSFWorkbook workbook;
    // Check file existence 
    if (file.exists() == false) {
        // Create new file if it does not exist
        workbook = new XSSFWorkbook();
    } else {
        try ( 
            // Make current input to exist file
            InputStream is = new FileInputStream(file)) {
                workbook = new XSSFWorkbook(is);
            }
    }
    XSSFSheet spreadsheet = workbook.getSheet("sheet1");
    // Check if the workbook is empty or not
    if (workbook.getNumberOfSheets() != 0) {
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
           if (workbook.getSheetName(i).equals("sheet1")) {
                spreadsheet = workbook.getSheet("sheet1");
            } else spreadsheet = workbook.createSheet("sheet1");
        }
    }
    else {
        // Create new sheet to the workbook if empty
        spreadsheet = workbook.createSheet("sheet1");
    }

    // Shift rows down if exist
    spreadsheet.shiftRows(0, spreadsheet.getLastRowNum(), 23);