public class Controller {

    @FXML
    private Button one ;

    @FXML
    private Button two ;

    public void initialize() {
        one.setOnAction(e -> numChange(1));
        two.setOnAction(e -> numChange(2));
    }

    private void numChange(int value) {
        // ...
    }
}