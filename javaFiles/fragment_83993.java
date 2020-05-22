public void openStage(Asset asset) {

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("optionsUI.fxml"));

    Parent root = null;
    try {
        root = fxmlLoader.load();
    } catch (IOException e) {
        e.printStackTrace();
    }
    OptionsController controller = fxmlLoader.getController();
    controller.selectedThingProperty().addListener((obs, oldSelection, newSelection) -> {
        // do whatever you need with newSelection....
    });

    // etc...
}