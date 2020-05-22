package loginExample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button btnRegister;

    // Reference to our main controller so we can access its content
    private MainController mainController;

    public LoginController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void initialize() {

        // Set our Register button to change the content of the main pane
        btnRegister.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginExample/RegisterLayout.fxml"));
                loader.setController(new RegisterController(mainController));

                // Set our RegisterLayout as the new content for our MainLayout window
                mainController.getContentPane().getChildren().clear();
                mainController.getContentPane().getChildren().add(loader.load());

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}