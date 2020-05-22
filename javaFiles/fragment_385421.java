myListView.setCellFactory(listView -> {
    ListCell<SomeType> cell = new ListCell<>(); // default implementation
    Label myLabel = new Label();
    cell.itemProperty().addListener((observable, oldValue, newValue) -> {
        if (oldValue != null) {
            myLabel.textProperty().unbind();
        }
        if (newValue == null) {
            setGraphic(null);
        } else {
            myLabel.bind(newValue.myProperty());
            setGraphic(myLabel);
        }
    });
    return cell ;
});