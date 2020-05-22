import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxInGridPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox box1 = new VBox();
        box1.setStyle("-fx-background-color: -fx-background; -fx-background: red ;");
        box1.getChildren().add(new Label("Content"));
        VBox box2 = new VBox();
        box2.setStyle("-fx-background-color: green ;");
        VBox box3 = new VBox();
        box3.setStyle("-fx-background-color: blue ;");

        GridPane root = new GridPane();
        root.add(box1, 0, 0);
        root.add(box2, 1, 0);
        root.add(box3, 2, 0);

        for (int i = 0 ; i < 3 ; i++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(100.0/3.0);
            cc.setHgrow(Priority.ALWAYS);
            root.getColumnConstraints().add(cc);
        }

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        root.getRowConstraints().add(rc);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}