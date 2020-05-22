@FXML
private void initialize() {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("LogoutFXML.fxml"));
    BorderPane border = loader.load();
    Scene scene = new Scene(border);
    logoutStage.setScene(scene);
    logoutStage.setTitle("Pit Stop - Logout");
    logoutStage.initModality(Modality.WINDOW_MODAL);
    logoutStage.initOwner(MainFXMLController.mainFXMLStage);
}

@FXML
public void logoutWindow() throws IOException {
    logoutStage.showAndWait();
}