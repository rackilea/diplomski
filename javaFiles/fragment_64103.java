import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import static javax.swing.Spring.height;
import static javax.swing.Spring.width;
import javafx.geometry.Pos;


public class Main extends Application {

@Override
public void start(Stage primaryStage) throws Exception {
//Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    Button btn1 = new Button();
    btn1.setText("Left");
    btn1.setOnAction((ActionEvent event) -> {
        System.out.println("Hello World!");
    });

    Button btn2 = new Button();
    btn2.setText("Right");
    btn2.setOnAction((ActionEvent event) -> {
       System.out.println("Hello World!");
    });

    Button btn3 = new Button();
    btn3.setText("Up");
    btn3.setOnAction((ActionEvent event) -> {
       System.out.println("Hello World!");
    });

    Button btn4 = new Button();
    btn4.setText("Down");
    btn4.setOnAction((ActionEvent event) -> {
       System.out.println("Hello World!");
    });
    Circle circle = new Circle();

    circle.setRadius(50);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);

   BorderPane rootPane  = new BorderPane();
   rootPane.setCenter(circle);
   HBox hb = new HBox(btn1, btn2, btn3, btn4);
   hb.setAlignment(Pos.CENTER);
   rootPane.setBottom(hb);

   Scene scene = new Scene(rootPane, 400, 400);
   primaryStage.setTitle("Move the circle!");
   primaryStage.setScene(scene);
   primaryStage.show();
  }
}