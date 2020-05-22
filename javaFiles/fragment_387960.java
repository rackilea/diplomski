TableView<Person> table = new TableView<>();
TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
TableColumn<Person, String> lastNameCol = new TableColumn<>("
Last Name");
firstNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

ObservableList<Person> data = FXCollections.observableArrayList();

SortedList<Person> sortedData = new SortedList<>(data);

// this ensures the sortedData is sorted according to the sort columns in the table:
sortedData.comparatorProperty().bind(table.comparatorProperty());

table.setItems(sortedData);

// programmatically set a sort column:
table.getSortOrder().addAll(firstNameCol);

// note that you should always manipulate the underlying list, not the sortedList:
data.addAll(new Person(...), new Person(...));