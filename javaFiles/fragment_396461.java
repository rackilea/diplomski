public class MainController {

    @FXML
    private final MenuItem deleteAllDataMenuItem ;

    private AuthenticationState authenticationState ;

    public void initialize() {

        authenticationState = new AuthenticationState();

        deleteAllDataMenuItem.disableProperty()
            .bind(authenticationState.loggedInProperty().not());

    }

    @FXML
    public void logIn() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginForm.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            LoginController loginController = fxmlLoader.getController();
            loginController.setAuthenticationState(authenticationState);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("HWI - Login");
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}