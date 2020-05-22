import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MenuDisplay extends Application {
    public void start(Stage stage) throws Exception {
        Label label = new Label("(*)");
        label.setStyle("-fx-background-color: null;");
        Scene dummyScene = new Scene(label, Color.TRANSPARENT);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image snapshot = label.snapshot(params, null);
        ImageView imageView = new ImageView(snapshot);

        Menu menu = new Menu("Choices");
        menu.getItems().addAll(
            new MenuItem("Broken Label Graphic", new Label("(*)")),
            new MenuItem("OK Rect", new Rectangle(16, 16, Color.FORESTGREEN)),
            new MenuItem("Fixed Snapshot", imageView)
        );
        MenuBar menuBar = new MenuBar(menu);

        Scene scene = new Scene(
                new VBox(menuBar), 100, 100
        );

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}