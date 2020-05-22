import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ShapeAnimationExample extends Application {

    private final Random rng = new Random();


    @Override
    public void start(Stage primaryStage) {


        List<Rectangle> fewRectangles = new ArrayList<>();
        for (int i = 0 ; i < 5 ; i++) {
            Rectangle r = new Rectangle(rng.nextInt(300)+50, rng.nextInt(300)+50, rng.nextInt(100)+50, rng.nextInt(100)+50);
            r.setFill(randomColor());
            fewRectangles.add(r);
        }

        List<Ellipse> ovals = new ArrayList<>();
        for (int i = 0 ; i < 5 ; i++) {
            Ellipse e = new Ellipse(rng.nextInt(400)+50, rng.nextInt(400)+50, rng.nextInt(50)+50, rng.nextInt(50)+50);
            e.setFill(randomColor());
            ovals.add(e);
        }

        Pane pane = new Pane();
        pane.setMinSize(600, 600);

        Timeline timeline = new Timeline();
        Duration timepoint = Duration.ZERO ;
        Duration pause = Duration.seconds(1);

        KeyFrame initial = new KeyFrame(timepoint, e -> pane.getChildren().addAll(fewRectangles));
        timeline.getKeyFrames().add(initial);

        for (Ellipse oval : ovals) {
            timepoint = timepoint.add(pause);
            KeyFrame keyFrame = new KeyFrame(timepoint, e -> pane.getChildren().add(oval));
            timeline.getKeyFrames().add(keyFrame);
        }

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

        timeline.play();
    }

    private Color randomColor() {
        return new Color(rng.nextDouble(), rng.nextDouble(), rng.nextDouble(), 1.0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}