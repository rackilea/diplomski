import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        HBox box = new HBox(10, createCard(true), createCard(true), createCard(false));
        box.setPadding(new Insets(100));
        primaryStage.setScene(new Scene(box));
        primaryStage.show();
    }

    private StackPane createCard(boolean circle) {
        Shape shape;
        if (circle) {
            shape = new Circle(50, Color.FORESTGREEN);
        } else {
            // create triangle
            shape = new Polygon(0, 0, 50, 100, -50, 100);
            shape.setFill(Color.FIREBRICK);
        }

        Rectangle cover = new Rectangle(0, 0, 100, 150);
        cover.mouseTransparentProperty()
                .bind(cover.fillProperty().isEqualTo(Color.TRANSPARENT));
        cover.setOnMouseClicked(event -> {
            event.consume();

            cover.setFill(Color.TRANSPARENT);

            PauseTransition pt = new PauseTransition(Duration.seconds(1));
            pt.setOnFinished(e -> cover.setFill(Color.BLACK));
            pt.playFromStart();
        });
        return new StackPane(shape, cover);
    }

}