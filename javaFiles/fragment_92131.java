import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Testing extends Application {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double WIDTH = screenSize.getWidth() - 80;
    double HEIGHT = screenSize.getHeight() - 80;

    @Override public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT, Color.WHITE);
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        primaryStage.setTitle("Circles!");

        // canvas.setOnMouseClicked(clickEvent -> {
        // for (int i = 0; i < 50; i++) {
        // double ran = Math.random() * WIDTH;
        // graphics.strokeOval(ran, ran, ran, ran);
        // }
        // });

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        new AnimationTimer() {
            @Override public void handle(long currentNanoTime) {
                for (int i = 0; i < 50; i++) {
                    double ran = Math.random() * WIDTH;
                    graphics.strokeOval(ran, ran, ran, ran);
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // Do nothing
                }
            }
        }.start();
    }
}