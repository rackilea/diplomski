package loginExample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class RegisterController {

    @FXML
    private Button btnCancel;

    private MainController mainController;

    public RegisterController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void initialize() {

        btnCancel.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginExample/LoginLayout.fxml"));
                loader.setController(new LoginController(mainController));

                // Set our RegisterLayout as the new content for our MainLayout window
                mainController.getContentPane().getChildren().clear();
                mainController.getContentPane().getChildren().add(loader.load());

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}