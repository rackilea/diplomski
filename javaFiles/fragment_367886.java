import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class LayoutExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        GridPane gridPane = new GridPane();


        Button backButton = new Button("Back");
        Button deleteButton = new Button("Delete");
        Button showAllButton = new Button("Show All");

        gridPane.add(backButton, 0, 0);
        gridPane.add(deleteButton, 1, 0);
        gridPane.add(showAllButton, 2, 0);

        ColumnConstraints leftCol = new ColumnConstraints();
        leftCol.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(leftCol, new ColumnConstraints(), new ColumnConstraints());

        gridPane.setPadding(new Insets(2));
        root.setBottom(gridPane);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}