//I use an instance of the workbook for the Excel workbook I'm working at the moment
Workbook wbook;

private CellValue formulaEvaluation(Cell cell) {
    FormulaEvaluator formulaEval = wbook.getCreationHelper().createFormulaEvaluator();
    return formulaEval.evaluate(cell);
}

public Double obtieneObjetoNumericoCelda(Cell cell) {
    Double dblValue = null;
    if (cell != null) {
        switch(cell.getCellType()) {
        case Cell.CELL_TYPE_NUMERIC:
            dblValue = cell.getNumericCellValue();
            break;
        case Cell.CELL_TYPE_FORMULA:
            CellValue objCellValue = formulaEvaluation(cell);
            if (objCellValue.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                dblValue = objCellValue.getNumberValue();
            }
            break;
        }
    }
    return dblValor;
}