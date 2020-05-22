private static Set<String> getReferencedWorkbooks(Workbook workbook) {
    Set<String> workbookNames = new HashSet<>();
    final EvaluationWorkbook evalWorkbook;
    if (workbook instanceof HSSFWorkbook) {
        evalWorkbook = HSSFEvaluationWorkbook.create((HSSFWorkbook) workbook);
    } else if (workbook instanceof XSSFWorkbook) {
        evalWorkbook = XSSFEvaluationWorkbook.create((XSSFWorkbook) workbook);
    } else {
        throw new IllegalStateException();
    }
    for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
        Sheet sheet = workbook.getSheetAt(i);
        final EvaluationSheet evalSheet = evalWorkbook.getSheet(i);
        for (Row r : sheet) {
            for (Cell c : r) {
                if (c.getCellType() == HSSFCell.CELL_TYPE_FORMULA) {
                    final EvaluationCell cell = evalSheet.getCell(c.getRowIndex(), c.getColumnIndex());
                    final Ptg[] formulaTokens = evalWorkbook.getFormulaTokens(cell);
                    for (Ptg formulaToken : formulaTokens) {
                        final int externalSheetIndex;
                        if (formulaToken instanceof Ref3DPtg) {
                            Ref3DPtg refToken = (Ref3DPtg) formulaToken;
                            externalSheetIndex = refToken.getExternSheetIndex();
                        } else if (formulaToken instanceof Ref3DPxg) {
                            Ref3DPxg refToken = (Ref3DPxg) formulaToken;
                            externalSheetIndex = refToken.getExternalWorkbookNumber();
                        } else {
                            externalSheetIndex = -1;
                        }

                        if (externalSheetIndex >= 0) {
                            final ExternalSheet externalSheet = evalWorkbook.getExternalSheet(externalSheetIndex);
                            workbookNames.add(externalSheet.getWorkbookName());
                        }
                    }
                }
            }
        }
    }
    return workbookNames;
}