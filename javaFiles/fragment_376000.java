import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class RandomCircles extends Application {
    private Random randomNumbers = new Random();
    private int count;
    private final double MAX_X = 600;
    private final double MAX_Y = 300;
    private final int FINAL_CIRCLES = 100;

    public void start(Stage primaryStage){
        Group baseDemo = new Group();
        for(count = 0; count <= FINAL_CIRCLES; count++){
            Circle initCircle = new Circle();
            initCircle.setStroke(Color.BLACK);
            initCircle.setStrokeWidth(3);
            initCircle.setRadius(5);
            initCircle.setCenterX(randomNumbers.nextInt((int) MAX_X));
            initCircle.setCenterY(randomNumbers.nextInt((int) MAX_Y));
            baseDemo.getChildren().add(initCircle);
        }

        Scene scene = new Scene(baseDemo);
        scene.setFill(Color.WHITE);
        scene.getWidth();

        primaryStage.setTitle("100");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}