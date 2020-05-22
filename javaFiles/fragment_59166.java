package loginExample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainController {

    @FXML
    private VBox contentPane;

    @FXML
    private void initialize() {

        // Initially start with the login layout
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginExample/LoginLayout.fxml"));

            // Set the LoginController and pass a reference to the MainController. This allows the LoginController
            // to access our contentPane.
            loader.setController(new LoginController(this));

            // Now, load the login layout into our contentPane
            GridPane gridPane = loader.load();
            contentPane.getChildren().add(gridPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public VBox getContentPane() {
        return contentPane;
    }
}