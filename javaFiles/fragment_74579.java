FileInputStream file = new FileInputStream("exceldatabase.xls");
    Workbook wb = new HSSFWorkbook(file);
    Sheet sheet = wb.getSheet("engine report");
    int lastRowNum = sheet.getLastRowNum();
    for(int rowIndex = 0 ; rowIndex < lastRowNum ; rowIndex++){
        Row currRow = sheet.getRow(rowIndex);
        if(currRow != null) {
            List<String> currRowValues = new ArrayList<String>();
            for(int cellNo = currRow.getFirstCellNum(); cellNo < currRow.getLastCellNum();cellNo++) {
                Cell currCell = currRow.getCell(cellNo);

                if(currCell != null) {
                    int cellType = currCell.getCellType();
                    switch(cellType) {
                        case Cell.CELL_TYPE_BLANK :
                            currRowValues.add("");
                        break;
                        case Cell.CELL_TYPE_BOOLEAN :
                            currRowValues.add(String.valueOf(currCell.getBooleanCellValue()));
                        break;
                        case Cell.CELL_TYPE_NUMERIC :
                            currRowValues.add(String.valueOf(currCell.getNumericCellValue()));
                        break;
                        case Cell.CELL_TYPE_STRING :
                            currRowValues.add(currCell.getStringCellValue());
                        break;
                        case Cell.CELL_TYPE_ERROR :
                            currRowValues.add("");
                        break;

                    }
                } else {
                    currRowValues.add("");
                }

            }

            // Add your code here 
            // Add current list to your UI or the way you want to display report
                System.out.println( currRowValues);
        }
    }