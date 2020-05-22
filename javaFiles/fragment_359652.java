private MainController parentController;

public void setParentController(MainController parentController) {
    this.parentController = parentController;
}

@FXML
private void selectButton (ActionEvent event) {
    this.parentController.setString("hello");
}