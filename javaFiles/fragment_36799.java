@FXML  private Label fontLabel;
@FXML  private ComboBox<String> size;

//create array of font sizes
ObservableList<String> fontSizes= FXCollections.observableArrayList("8", "10",
"11", "12", "14", "16", "18","20", "24", "30", "36", "40", "48", "60",
"72");


@FXML
public void initialize() {
    size.setItems(fontSizes);
    size.setOnAction(e-> updateLabel());
}

private void updateLabel() {
    double fontSize = Double.valueOf(size.getSelectionModel().getSelectedItem());
    fontLabel.setFont(  new Font(fontSize ));
}