checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {

    // Loop through entire TableView to set the selected property for each Item
    for (Item item : tableView.getItems()) {
        item.setSelected(newValue);
    }
});