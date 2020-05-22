public static void xlxTOcsvConverter(String inFile, String inSheet, String outFile) {
    DataRefresh GetIt = new DataRefresh();
    String data = "";
    try {
        FileWriter output = new FileWriter(outFile);
        Workbook wb = WorkbookFactory.create(new FileInputStream(inFile));
        Sheet sheet = wb.getSheet(inSheet);

        Row row = null;
        for(int i = 0; i<=sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            if (row == null) {
                data = "empty row";
                output.write(data);
            } else {
                for(int j = 0; j<row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    data = GetIt.getCellValue(cell);
                    output.write(data + ((j<row.getLastCellNum()-1) ? ";" : ""));
                }
            }
            output.write(EOL);
        }


        output.close();
    }
    catch(Exception e) {
        e.printStackTrace();
    }
}