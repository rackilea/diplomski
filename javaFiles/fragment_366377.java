import javafx.application.Application;
import javafx.scene.shape.Ellipse;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ellipseICE07 extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();

        Text text = new Text("Name");
        text.setLayoutY(205);
        text.setLayoutX(255);
        text.setStroke(null);
        text.setFill(Color.BLUE);
//      text.setOpacity(2.0);
        text.setFont(Font.font("Cambria", FontWeight.BOLD, 34));

        for (int o = 0; o < 180; o += 10) {
            Ellipse ep = new Ellipse(300, 200, 100, 3);
            ep.setRotate(o);
            ep.setFill(null);
//          ep.setOpacity(0.3);
            ep.setStroke(Color.RED);
            pane.getChildren().add(ep);
        }

        for (int i = 0; i < 180; i += 5) {
            Ellipse ep1 = new Ellipse(300, 200, 100, 3);
            ep1.setRotate(i);
            ep1.setFill(null);
//          ep1.setOpacity(0.3);
            ep1.setStroke(Color.RED);
            pane.getChildren().add(ep1);

        }

        pane.getChildren().add(text);

        Scene scene = new Scene(pane, 600, 400);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}