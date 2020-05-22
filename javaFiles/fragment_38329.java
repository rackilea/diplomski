import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPaneTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        AnchorPane child1 = new AnchorPane();
        child1.setPrefSize(400., 600.);
        child1.setStyle("-fx-background-color: red;");

        AnchorPane child2 = new AnchorPane();
        child2.setPrefSize(400., 300.);
        child2.setStyle("-fx-background-color: blue;");

        anchorPane.getChildren().addAll(child1, child2);

        stage.setScene(new Scene(anchorPane));
        stage.show();
    }
}