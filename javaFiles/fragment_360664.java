public void printTable(TableView<ObservableList> table, String subject, String from, Date date, String email) {

    //Data.
    ObservableList<ObservableList> data = FXCollections.observableArrayList();

    //Columns.
    javafx.scene.control.TableColumn col = new javafx.scene.control.TableColumn();
    col.setText("Subject");
    table.getColumns().addAll(col);

    javafx.scene.control.TableColumn col2 = new javafx.scene.control.TableColumn();
    col.setText("From");
    table.getColumns().addAll(col2);

    javafx.scene.control.TableColumn col3 = new javafx.scene.control.TableColumn();
    col.setText("Date");
    table.getColumns().addAll(col3);

    javafx.scene.control.TableColumn col4 = new javafx.scene.control.TableColumn();
    col.setText("Email");
    table.getColumns().addAll(col4);

    //Row.
    ObservableList<String> row = FXCollections.observableArrayList();

    row.add(subject);
    row.add(from);
    row.add(date.toString());
    row.add(email);

    //Adding the row to the data.
    data.add(row);

    //Setting the data of the table.
    table.setItems(data);

    //Hiding the email column.
    table.getColumns().get(4).setVisible(false);
}

@FXML 
private void tablePressed() {
    if(table.getSelectionModel().getSelectedItem() != null) {
        String message = table.getSelectionModel().getSelectedItem().get(4).toString();
        textField.setText(message);
    }
}