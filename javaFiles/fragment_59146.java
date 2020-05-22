import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CircleTransitions extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        final Group group = new Group();
        final Scene scene = new Scene(group, 500, 500, Color.WHITE);
        stage.setScene(scene);
        stage.setTitle("Circles");
        stage.show();

        Circle path = new Circle(250,250,200);
        path.setFill(Color.WHITE);

        DoubleProperty angle = new SimpleDoubleProperty();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), new KeyValue(angle, 360)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        group.getChildren().add(path);

        for (int i=0; i<5; i++) {
            Circle circle = new Circle(250, 450, 15);
            circle.setFill(Color.DARKRED);
            Rotate rotate = new Rotate(0, 250, 250);
            circle.getTransforms().add(rotate);
            rotate.angleProperty().bind(angle.add(360.0 * i / 5));
            group.getChildren().add(circle);
        }
    }

    public static void main(final String[] arguments) {
        Application.launch(arguments);
    }
}