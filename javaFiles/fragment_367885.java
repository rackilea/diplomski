import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class LayoutExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        AnchorPane anchorPane = new AnchorPane();

        Button backButton = new Button("Back");
        Button deleteButton = new Button("Delete");
        Button showAllButton = new Button("Show All");

        HBox rightButtons = new HBox(deleteButton, showAllButton);

        anchorPane.getChildren().addAll(backButton, rightButtons);

        AnchorPane.setBottomAnchor(rightButtons, 2.0);
        AnchorPane.setBottomAnchor(backButton, 2.0);

        AnchorPane.setLeftAnchor(backButton, 2.0);
        AnchorPane.setRightAnchor(rightButtons, 2.0);

        root.setBottom(anchorPane);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}