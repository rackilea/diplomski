import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserDisplay extends Application {
    @Override public void start(Stage stage) {
        String[] users = { "Huey", "Dewey", "Louie" };

        VBox layout = new VBox(10);

        // ALTERNATIVE 1: add labels in a loop.
        for (String user: users) {
            Label userLabel = new Label(user);
            layout.getChildren().add(userLabel);
        }

        // ALTERNATIVE 2: use the built-in ListView component.
        ListView<String> listView = new ListView<>(
                FXCollections.observableArrayList(users)
        );
        layout.getChildren().add(listView);

        layout.setPadding(new Insets(10));
        layout.setPrefSize(100,200);

        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}