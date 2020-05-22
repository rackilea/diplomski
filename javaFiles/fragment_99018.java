import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Sedrick (SedJ601)
 * 
 */
public class App extends Application {
    //Declaring variables here gives them greater scope
    Rectangle rectangle = new Rectangle(240, 240, Color.BLUE);
    Circle circle = new Circle(50, Color.RED);    
    StackPane root = new StackPane();

    @Override
    public void start(Stage primaryStage) {
        rectangle.setOnMouseClicked(handleMouseClick);//Set mouse click handler
        circle.setOnMouseClicked(handleMouseClick);//Set mouse click handler

        root.getChildren().add(rectangle);//Set initial shape.

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }    

    EventHandler<MouseEvent> handleMouseClick = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {
            if(root.getChildren().get(0).equals(rectangle))//if the current shape showing is rectangle change it to circle, else do the opposite
            {
                root.getChildren().set(0, circle);
            }
            else
            {
                root.getChildren().set(0, rectangle);
            }
        }
    };
}