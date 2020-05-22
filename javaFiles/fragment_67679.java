public class ViewController {

    @FXML
    private Button exitBtn ;

    @FXML
    private Button openBtn ;

    public void initialize() {
        // initialization here, if needed...
    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        // I really don't recommend using a single handler like this,
        // but it will work
        if (event.getSource() == exitBtn) {
            exitBtn.getScene().getWindow().hide();
        } else if (event.getSource() == openBtn) {
            // do open action...
        }
        // etc...
    }
}