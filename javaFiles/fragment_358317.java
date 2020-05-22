import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        Circle circle = new Circle(100, 100, 30);
        Path path = new Path();

        double x = 144;

        path.getElements().add(new MoveTo(x, 140));
        path.getElements().add(new LineTo(500, 100));
        path.getElements().add(new ClosePath());

        path.setStrokeWidth(60);
        path.setStrokeLineCap(StrokeLineCap.ROUND);
        path.setStrokeLineJoin(StrokeLineJoin.ROUND);

        Shape shape = Shape.intersect(circle, path);

        boolean intersects = shape.getBoundsInLocal().getWidth() != -1;

        System.out.println("Intersects: " + intersects);

        Pane pane = new Pane();
        pane.getChildren().addAll(circle, path);
        root.setCenter(pane);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}