public class ControllerSignIn implements Initializable {
    @FXML
    private Button forgot;
    @FXML
    private Button back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        forgot.setOnAction(e -> ForgotPassword.setUpWindow());
        back.setOnAction(e -> ForgotPassword.closeWindow());
    }
}