public class Controller {
    private static final String WORKER = "/sample/worker_homescreen.fxml";
    private static final String MANAGER = "/sample/manager_homescreen.fxml";

    @FXML
    private void handleLoginButton() {
        ...

        if (!resultSet.next()) {
            infoBox("Enter Correct Username and Password", "Failed", null);
        } else {
            if ("Employee".equals(function)) {
                infoBox("Login Successfull", "Success", null);
                showMainView(getClass().getResource(WORKER));

            } else if ("Manager".equals(function)) {
                infoBox("Login Successfull", "Success", null);
                showMainView(getClass().getResource(MANAGER));
            }
        }
    }

    private void showMainView(URL url) {
        try {
            Parent parent = FXMLLoader.load(url);

            Stage stage = new Stage();
            stage.setScene(new Scene(parent, 800, 600));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}