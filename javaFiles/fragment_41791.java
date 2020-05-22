import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class DialogDisplayApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "add-dialog.fxml"
                )
        );

        stage.setScene(new Scene(new VBox(new Label("Main Window")), 600, 400));
        stage.show();

        Dialog<String> dialog = loader.load();

        dialog.initOwner(stage);
        dialog.showAndWait();

        System.out.println(dialog.getResult());
    }

    public static void main(String[] args) {
        launch(args);
    }
}