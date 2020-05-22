TextField textField = new TextField();
textField.setOnAction(e -> {
    AddBillTable selectedItem = table.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
        selectedItem.setQuantity(Integer.parseInt(textField.getText()));
    }
});