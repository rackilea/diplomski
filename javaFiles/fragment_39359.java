checkMenuItem.selectedProperty().addListener((obs, wasSelected, isSelected) -> {

    if (isSelected) {
        pane.setStyle("-fx-background-color: black");
    }
    else {
        pane.setStyle("-fx-background-color: white");
    }

});