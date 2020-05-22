public void createColums(TableView table,int size){
    for(int x = 1; x<=size; x++){ //careful with indexes
        TableColumn<ObservableList<String>,String> t = new TableColumn<>("Paramiter "+x);
        t.setPrefWidth(120);
        final int X = x;
        t.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().get(X-1)));
        table.getColumns().add(t);
    }
    TableColumn t = new TableColumn("Target");
    t.setPrefWidth(120);
    table.getColumns().add(t);
}