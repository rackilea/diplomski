import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class LayoutExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        HBox hbox = new HBox();

        Button backButton = new Button("Back");
        Button deleteButton = new Button("Delete");
        Button showAllButton = new Button("Show All");

        Pane spacer = new Pane();

        HBox.setHgrow(spacer, Priority.ALWAYS);

        hbox.getChildren().addAll(backButton, spacer, deleteButton, showAllButton);
        hbox.setPadding(new Insets(2));

        root.setBottom(hbox);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}