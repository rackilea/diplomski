private SearchResultDataCell[] prepareTable(Object[] test, ArrayList<Integer> visibleIndexes){
    SearchResultDataCell[] row = new SearchResultDataCell[visibleIndexes.size()];
    for(int index = 0 ; index < visibleIndexes.size(); index++){
        row[index] = dataCell(notNull(String.valueOf(test[visibleIndexes.get(index)])));
    }
    return row;
}