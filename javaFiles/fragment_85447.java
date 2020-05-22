int cellType = cell.getCellType();
handleCell(cell, cellType);

private void handleCell(Cell cell, int cellType) {
        if (HSSFCell.CELL_TYPE_NUMERIC == cellType)
            System.out.print(cell.getNumericCellValue() + "     ");
        else if (HSSFCell.CELL_TYPE_STRING == cellType)
            System.out.print(cell.getStringCellValue() + "     ");
        else if (HSSFCell.CELL_TYPE_BOOLEAN == cellType)
            System.out.print(cell.getBooleanCellValue() + "     ");
        else if (HSSFCell.CELL_TYPE_BLANK == cellType)
            System.out.print("BLANK     ");
        else if (HSSFCell.CELL_TYPE_FORMULA == cellType)
            handleCell(cell, cell.getCachedFormulaResultType());
        else 
            System.out.print("Unknown cell type " + cellType);
   }