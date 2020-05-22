@FXML
TableView<String> tblView; // your table view here

TableColumn<String, String> columnMain = new TableColumn<>();
columnMain.setCellValueFactory(new PropertyValueFactory<>("someValue"));
columnMain.setText("some text");

TableColumn<String, String> columnChild1 = new TableColumn<>();
columnChild1 .setCellValueFactory(new PropertyValueFactory<>("someValue"));
columnChild1 .setText("some text");

TableColumn<String, String> columnChild2 = new TableColumn<>();
columnChild2 .setCellValueFactory(new PropertyValueFactory<>("someValue"));
columnChild2 .setText("some text");

columnMain.getColumns().add(columnChild1);
columnMain.getColumns().add(columnChild2);

// columnMain now has two child columns columnChild1 and columnChild2

tblView.getColumns().add(columnMain);