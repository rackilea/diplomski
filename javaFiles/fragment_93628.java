package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Controller {

    @FXML  Canvas canvas;

    @FXML
    public void drawCanvas(){

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(3);
        gc.setStroke(Color.BLACK);
        System.out.println("drawCanvas");

        try {
            canvas.setOnMousePressed(event -> {
                System.out.println("Mouse click");
                gc.beginPath();
                gc.lineTo(event.getSceneX(), event.getSceneY());
                gc.stroke();
            });

            canvas.setOnMouseDragged(event -> {
                System.out.println("Mouse dragged");
                gc.lineTo(event.getSceneX(), event.getSceneY());
                gc.stroke();
            });
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }

    }
}