import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LabelBackground extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Sally collects seashells on the seashore");
        StackPane centeredLabel = new StackPane(label);
        centeredLabel.setStyle("-fx-background-color: coral;");

        StackPane root = new StackPane(centeredLabel);
        root.setPadding(new Insets(10));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}