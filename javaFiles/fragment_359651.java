@FXML
private ChildController childController;

@Override
public void initialize(URL url, ResourceBundle rb) {
    childController.setParentController(this);
}