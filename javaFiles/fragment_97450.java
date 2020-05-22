@FXML private javafx.scene.control.Button closeButton;

@FXML
private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) closeButton.getScene().getWindow();
    // do what you have to do
    stage.close();
}