for ( TableColumn<X, ?> col : getColumns() ) {
        TableColumn<X, ?> newCol = create(col);
}

public <Y> TableColumn<X, ?> create(TableColumn<X, Y> tc){
    TableColumn<X, Y> newCol = new TableColumn<>();
    newCol.setCellValueFactory( tc.getCellValueFactory() );         
    return newCol;
}