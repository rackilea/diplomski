public class SomeController {

    // injected by FXMLLoader:
    @FXML
    private TextField someTextField ;

    // Injected by Spring:
    @Inject
    private MyService service ;

    public void initialize() {
        someTextField.setText(service.getSomeText());
    }

    // event handler:
    @FXML
    private void performAction(ActionEvent e) {
        service.doAction(...);
    }
}