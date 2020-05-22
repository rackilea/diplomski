import java.util.Random;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Walker extends Pane {

    private static Random random = new Random();

    PVector location;
    PVector velocity;
    PVector acceleration;
    float topspeed;

    double width = 30;
    double height = width;
    double centerX = width / 2.0;
    double centerY = height / 2.0;
    double radius = width / 2.0;

    Circle circle;

    public Walker() {

        location = new PVector(random.nextDouble() * width, random.nextDouble() * height, 0);
        velocity = new PVector(0, 0, 0);
        topspeed = 4;

        circle = new Circle(radius);
        circle.setCenterX(radius);
        circle.setCenterY(radius);

        circle.setStroke(Color.BLUE);
        circle.setFill(Color.BLUE.deriveColor(1, 1, 1, 0.3));

        getChildren().add(circle);

    }

    public void step(PVector mouse) {

        PVector dir = PVector.sub(mouse, location);
        dir.normalize();
        dir.mult(0.5);
        acceleration = dir;
        velocity.add(acceleration);
        velocity.limit(topspeed);
        location.add(velocity);

    }

    public void checkBoundaries() {

        if (location.x > Settings.SCENE_WIDTH) {
            location.x = 0;
        } else if (location.x < 0) {
            location.x = Settings.SCENE_WIDTH;
        }

        if (location.y > Settings.SCENE_HEIGHT) {
            location.y = 0;
        } else if (location.y < 0) {
            location.y = Settings.SCENE_HEIGHT;
        }
    }

    public void display() {
        relocate(location.x - centerX, location.y - centerY);
    }
}