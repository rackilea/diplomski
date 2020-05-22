import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LabelTest extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Label label = new Label("Testing testing 1 2 3");
        BorderPane root = new BorderPane();
        //center label by
        //BorderPane.setAlignment(label, Pos.CENTER);
        //root.setBottom(label);
        //OR
        root.setBottom(new StackPane(label));
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}