private XSSFWorkbook createWorkbookFromTable(TableViewer table) {
    // create a workbook
    XSSFWorkbook wb = new XSSFWorkbook();

    // add a worksheet
    XSSFSheet sheet = wb.createSheet("My Table Data");

    // shade the background of the header row
    XSSFCellStyle headerStyle = wb.createCellStyle();
    headerStyle.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
    headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
    headerStyle.setBorderTop(CellStyle.BORDER_THIN);
    headerStyle.setBorderBottom(CellStyle.BORDER_THIN);
    headerStyle.setBorderLeft(CellStyle.BORDER_THIN);
    headerStyle.setBorderRight(CellStyle.BORDER_THIN);
    headerStyle.setAlignment(HorizontalAlignment.CENTER);

    // add header row
    Table table = table.getTable();
    TableColumn[] columns = table.getColumns();
    int rowIndex = 0;
    int cellIndex = 0;
    XSSFRow header = sheet.createRow((short) rowIndex++);
    for (TableColumn column : columns) {
        String columnName = column.getText();
        XSSFCell cell = header.createCell(cellIndex++);
        cell.setCellValue(column.getText());
        cell.setCellStyle(headerStyle);
    }

    // add data rows
    TableItem[] items = table.getTable().getItems();
    for (TableItem item : items) {
        // create a new row
        XSSFRow row = sheet.createRow((short) rowIndex++);
        cellIndex = 0;

        for (int i = 0; i < columns.length; i++) {
            // create a new cell
            String columnName = tableColumnNames[i];
            XSSFCell cell = row.createCell(cellIndex++);

            // set the horizontal alignment (default to RIGHT)
            XSSFCellStyle cellStyle = wb.createCellStyle();
            ha = HorizontalAlignment.RIGHT;
            cellStyle.setAlignment(ha);
            cell.setCellStyle(cellStyle);

            // set the cell's value
            String text = item.getText(i);
            cell.setCellValue(text);
        }
    }

    // autofit the columns
    for (int i = 0; i < columns.length; i++) {
        sheet.autoSizeColumn((short) i);
    }

    return wb;
}