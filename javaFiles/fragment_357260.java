public class SomeController {

    private final MyService service ;

    public SomeController(MyService service) {
        this.service = service ;
    }

    // injected by FXMLLoader:
    @FXML
    private TextField someTextField ;

    public void initialize() {
        someTextField.setText(service.getSomeText());
    }

    // event handler:
    @FXML
    private void performAction(ActionEvent e) {
        service.doAction(...);
    }
}