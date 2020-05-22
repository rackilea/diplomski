FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

// suppose your formula is in B3
CellReference cellReference = new CellReference("B3"); 
Row row = sheet.getRow(cellReference.getRow());
Cell cell = row.getCell(cellReference.getCol()); 

CellValue cellValue = evaluator.evaluate(cell);

switch (cellValue.getCellType()) {
case Cell.CELL_TYPE_BOOLEAN:
    System.out.println(cellValue.getBooleanValue());
    break;
case Cell.CELL_TYPE_NUMERIC:
    System.out.println(cellValue.getNumberValue());
    break;
case Cell.CELL_TYPE_STRING:
    System.out.println(cellValue.getStringValue());
    break;
case Cell.CELL_TYPE_BLANK:
    break;
case Cell.CELL_TYPE_ERROR:
    break;

// CELL_TYPE_FORMULA will never happen
case Cell.CELL_TYPE_FORMULA: 
    break;
}