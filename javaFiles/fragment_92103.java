// Get content of cells
// import org.apache.poi.ss.usermodel.*;

Sheet sheet1 = wb.getSheetAt(0);
for (Row row : sheet1) {
    for (Cell cell : row) {
        CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
        System.out.print(cellRef.formatAsString());
        System.out.print(" - ");

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                System.out.println(cell.getRichStringCellValue().getString());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.println(cell.getDateCellValue());
                } else {
                    System.out.println(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                System.out.println(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                System.out.println(cell.getCellFormula());
                break;
            default:
                System.out.println();
        }
    }
}