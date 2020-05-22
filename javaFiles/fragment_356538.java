Sheet sheet = wb.getSheetAt(0);
for (Row row : sheet) {
    for (Cell cell : row) {
        if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            CellRangeAddress range = getMergedRegion(cell);
            if (range != null) {
                Cell mergeValue = sheet.getRow(range.getFirstRow()).getCell(range.getFirstColumn());
                System.out.println("Cell " + cell.getAddress() + ": " + "merged cell (" + 
                    range.formatAsString() + ") " + mergeValue.getStringCellValue());
            } else {
                System.out.println("Cell " + cell.getAddress() + ": " + "blank");
            }
        } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            System.out.println("Cell " + cell.getAddress() + ": " + cell.getStringCellValue());                 
        }
    }
}