private final StringProperty value = new SimpleStringProperty();

public StringProperty valueProperty() {
    return value;
}

@FXML
private void selectButton (ActionEvent event) {
    value.set("hello");
}