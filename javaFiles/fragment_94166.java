TableView<City> tableView = new TableView();
TableColumn idColumn = new TableColumn("Id");
idColumn.setCellValueFactory(
        new PropertyValueFactory<>("id"));
TableColumn cityColumn = new TableColumn("City");
cityColumn.setCellValueFactory(
        new PropertyValueFactory<>("name"));

 tableView.getColumns().setAll(idColumn, cityColumn);
 tableView.getItems().addAll(data);