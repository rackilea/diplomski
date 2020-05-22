while(change.next(){
    if(change.wasAdded()){
        TableView.TableViewSelectionModel selectionModel = viewCategory.getSelectionModel();
        ObservableList selectedCells = selectionModel.getSelectedCells();
        TablePosition tablePosition = (TablePosition) selectedCells.get(0);
        int row = tablePosition.getRow(); // yields the row that the currently selected cell is in
        System.out.println(row);
    }
}