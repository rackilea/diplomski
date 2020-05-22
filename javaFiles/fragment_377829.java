final ObservableList<String> strings = FXCollections.observableArrayList();
for (int i = 0; i <= 50; i++) 
    strings.add("Item " + i);

// Create the CheckComboBox with the data
final CheckComboBox<String> checkComboBox = new CheckComboBox<>(strings);
for (int i = 0; i< checkComboBox.getCheckModel().getItemCount(); i++) {
    if (i % 3 == 0)
        checkComboBox.getCheckModel().check(i);
}
checkComboBox.setSkin(new CheckComboReadOnlySkin<String>(checkComboBox));
checkComboBox.getStylesheets().add(getClass().getResource("app.css").toString());