public static void main(String args[]) throws IOException {
    DataFormatter formatter = new DataFormatter();
    HSSFWorkbook input_workbook;
    HSSFWorkbook workbook_Output_Final;

    HSSFSheet input_workbook_sheet;

    HSSFRow row_Output;
    HSSFRow row_1_index;
    HSSFRow row_2_index;

    String value1 = "";
    String value2 = "";
    int count;

    FileInputStream input_file = new FileInputStream("c:\\temp\\test.xls");
    input_workbook = new HSSFWorkbook(new POIFSFileSystem(input_file));

    for (int sheetnum = 0; sheetnum < input_workbook.getNumberOfSheets(); sheetnum++) {

        input_workbook_sheet = input_workbook.getSheetAt(sheetnum);

        int input_workbook_sheet_total_row = input_workbook_sheet.getLastRowNum(); 

        for (int input_workbook_sheet_row_1 = input_workbook_sheet_total_row; input_workbook_sheet_row_1 >=0; input_workbook_sheet_row_1--) { // traversing

            for (int input_workbook_sheet_row_2 = input_workbook_sheet_total_row; input_workbook_sheet_row_2 >= 0 ; input_workbook_sheet_row_2--) {

                row_1_index = input_workbook_sheet.getRow(input_workbook_sheet_row_1);
                row_2_index = input_workbook_sheet.getRow(input_workbook_sheet_row_2); 

                if (row_1_index != null && row_2_index != null && row_1_index != row_2_index) {
                    count = 0;
                    value1 = "";
                    value2 = "";

                    int row_1_max = row_1_index.getLastCellNum() - 1;
                    for (int row_1_index_cell = 0; row_1_index_cell < row_1_max; row_1_index_cell++) {
                        try {
                            value1 = value1 + formatter.formatCellValue(row_1_index.getCell(row_1_index_cell)); 

                            value2 = value2 + formatter.formatCellValue(row_2_index.getCell(row_1_index_cell)); 

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                        count++;

                        if (value1.equals(value2)) {
                            System.out.println("deleted : " + row_2_index.getRowNum());
                            System.out.println("------------------");
                            input_workbook_sheet.removeRow(row_2_index);


                            input_workbook_sheet.shiftRows(
                                    row_2_index.getRowNum() + 1, 
                                    input_workbook_sheet_total_row, 
                                    -1, 
                                    true, 
                                    true);
                        }


                    }

                }
            }
        }

    }
    FileOutputStream fileOut = new FileOutputStream("c:\\temp\\workbook.xls");
    input_workbook.write(fileOut);
    fileOut.close();
    input_file.close();
    input_workbook.close();
}