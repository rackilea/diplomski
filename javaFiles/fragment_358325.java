@FXML
TableView<Person> tblView;

TableColumn<String, String> columnMain = new TableColumn<>();
columnMain.setText("Name");

TableColumn<String, String> columnChild1 = new TableColumn<>();
columnChild1 .setCellValueFactory(new PropertyValueFactory<>("firstName"));
columnChild1 .setText("First Name");

TableColumn<String, String> columnChild2 = new TableColumn<>();
columnChild2 .setCellValueFactory(new PropertyValueFactory<>("lastName"));
columnChild2 .setText("Last Name");

columnMain.getColumns().add(columnChild1);
columnMain.getColumns().add(columnChild2);

// columnMain now has two child columns columnChild1 and columnChild2

tblView.getColumns().add(columnMain);