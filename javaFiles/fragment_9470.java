@Override
public void initialize(URL location, ResourceBundle resources) {
    comboBox.getItems().removeAll(comboBox.getItems());
    comboBox.getItems().addAll("Option A", "Option B", "Option C");
    comboBox.getSelectionModel().select("Option B");
}