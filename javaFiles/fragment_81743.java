package formatter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PeopleApp extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = loader.load(
            getClass().getResourceAsStream(
                "people.fxml"
            )
        );

        stage.setScene(
            new Scene(
                mainPane
            )
        );

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}