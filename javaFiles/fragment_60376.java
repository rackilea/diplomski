import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Orbit extends Application {

    private static final double WIDTH = 500, HEIGHT = 400, EARTH_RADIUS = 150;
    private Rotate earthRotate;
    private Circle earth;

    @Override
    public void start(Stage stage) {

        stage.setTitle("Rotation transformation example");

        var sun = new Sphere(20);
        sun.setTranslateX(WIDTH/2);   sun.setTranslateY(HEIGHT/2);

        earth = new Circle(10);
        earth.translateXProperty().bind(sun.translateXProperty());
        earth.translateYProperty().bind(sun.translateYProperty().subtract(EARTH_RADIUS));
        earthRotate = new Rotate(0, 0, EARTH_RADIUS);
        earth.getTransforms().add(earthRotate);

        Pane root = new Pane(sun, earth);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();
        animate();
    }

    private void animate() {

        Timeline earthTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(earthRotate.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(5), new KeyValue(earthRotate.angleProperty(), 360))
         );
        earthTimeline.setCycleCount(Timeline.INDEFINITE);
        earthTimeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}