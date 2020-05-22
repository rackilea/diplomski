package finder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TableScrollerApp extends Application {
    @Override public void start(final Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("tablescroller.fxml")
        );
        Parent parent = loader.load();

        stage.setScene(new Scene(new Group(parent)));
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}