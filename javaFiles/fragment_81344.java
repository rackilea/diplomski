...
    workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

    Sheet firstSheet = workbook.getSheetAt(0);
    Iterator<Row> iterator = firstSheet.iterator();

    while (iterator.hasNext())
...