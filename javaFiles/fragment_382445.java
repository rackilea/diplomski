public List<String> processSheet(Sheet sheet) {
    List<String> headers = new ArrayList<>();
    Iterator<Row> rowIterator = sheet.iterator();
    int rowCnt = 0;
    while (rowIterator.hasNext()) {
        Row currentRow = rowIterator.next();
        for (int i = 0; i < currentRow.getLastCellNum(); ++i) {
            Cell currentCell = currentRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            String cellValue = excelManager.evalCell(currentCell);

            headers.add(rowCnt + (i * (rowCnt+1)), cellValue);
        }
        ++rowCnt;
    }

    return headers;
}