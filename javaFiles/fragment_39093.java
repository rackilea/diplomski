@FXML
private void initialize() {
    toggle.selectedProperty().addListener((observable, oldValue, newValue) -> {
        if(newValue) {
            //do something
        } else {
            //something else
        }
    });

}