import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ButtonGraphicCssTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button();
        Image image = new Rectangle(20, 20, Color.CORNFLOWERBLUE).snapshot(null, null);
        ImageView imageView = new ImageView(image);
        imageView.getStyleClass().add("graphic");
        button.setGraphic(imageView);

        button.setOnAction(e -> button.setDisable(true));

        StackPane root = new StackPane(button);
        Scene scene = new Scene(root, 350, 120);
        scene.getStylesheets().add("button-graphic-disabled.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}