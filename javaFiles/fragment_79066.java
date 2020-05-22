import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Rectangle rect1 = new Rectangle(400,100);
        Rectangle rect2 = new Rectangle(400,125);
        Rectangle rect3 = new Rectangle(400,175);
        Rectangle rect4 = new Rectangle(200,250);

        rect1.setFill(Color.BLUE);
        rect2.setFill(Color.RED);
        rect3.setFill(Color.YELLOW);
        rect4.setFill(Color.GREEN);

        rect2.setLayoutY(100);
        rect3.setLayoutY(225);
        rect4.setLayoutX(200);
        rect4.setLayoutY(150);

        root.getChildren().addAll(rect1,rect2,rect3,rect4);


        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
}