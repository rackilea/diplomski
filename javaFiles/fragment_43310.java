private ObservableList<List<String>> fnlData;

tmpListData = new LinkedList<List<String>>();

for (List<String> row : fnlData){
    List<String> newRow = new LinkedList<>();
    for (int col : colOrder){
        String value = row.get(col);
        newRow.add(value);
    }
    tmpListData.add(newRow);
}