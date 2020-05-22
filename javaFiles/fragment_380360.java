import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class LineChartSample extends Application {

    int clickCount = 0;

    @Override public void start(Stage stage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 500);
        Line line = new Line(0, 200, 500, 200);

        line.setStrokeWidth(2);
        line.setStroke(Color.RED);

        Bounds b = line.getBoundsInParent();
        System.out.println(b);

        pane.getChildren().add(line);

        pane.setOnMouseClicked((event)->{
            ++clickCount;
            double d = clickCount*20.0;
            Rectangle clipRect = new Rectangle(b.getMinX() + d, b.getMinY(), b.getWidth() - 2*d, b.getHeight());
            line.setClip(clipRect);
        });

        stage.setWidth(700);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}