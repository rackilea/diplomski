private SearchResultDataCell[] prepareTable(Object[] result) {
    final SearchResultDataCell row[] = new SearchResultDataCell[COUNT];
    for(int index = 0; index < row.length; index++) {
        row[index] = dataCell(notNull(String.valueOf(result[index])));
    }
    return row; 
}