ObservableList<BarFile> devCheckboxList = FXCollections.observableArrayList();
//List gets populated with files elsewhere

    switch (chk.getText()) {
    //Check to see which checkbox is selected
    case "DEV":
        // tableView.getItems().clear();
        System.err.println("DEV IS TRUE");
        environmentCheck("DEV");
        //Add to listview
        tableView.setItems(devCheckboxList);
        break;

}