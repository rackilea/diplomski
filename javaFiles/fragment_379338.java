public static void main(String[] args) throws JDOMException, IOException {
        File excelFile = new File("C:/temp/test.xls");
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheetname");

        Row r = null;
        CellStyle cellStyle = workbook.createCellStyle();
        // CreationHelper createHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(workbook.createDataFormat().getFormat("yyyy-MM-dd"));
        for (int i = 0; i < 2; i++) {
            switch (i) {
            case 0:
                r = sheet.createRow(0);
                r.setRowStyle(cellStyle);
                break;
            case 1:
                r = sheet.createRow(1);
                r.setRowStyle(cellStyle);
                break;
            default:
                break;
            }
        }

        try (FileOutputStream out = new FileOutputStream(excelFile)) {
            workbook.write(out);
        }
        Desktop.getDesktop().open(excelFile);
    }