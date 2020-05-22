import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class ColoredShapes extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        // square
        Rectangle square = new Rectangle(40, 40);
        square.setFill(Color.BLUE);
        // triangle
        Polygon triangle = new Polygon();
        triangle.setLayoutX(80);
        triangle.getPoints().addAll(40.0, 0.0, 80.0, 40.0, 0.0, 40.0);
        triangle.setFill(Color.RED);
        // circle
        Circle circle = new Circle(20);
        circle.setLayoutX(240);
        circle.setCenterY(20);

        registerHandler(square, Color.BLUE, Color.MAGENTA);
        registerHandler(triangle, Color.RED, Color.MAGENTA);
        registerHandler(circle, Color.BLACK, Color.MAGENTA);

        group.getChildren().add(circle);
        group.getChildren().add(triangle);
        group.getChildren().add(square);

        Scene scene = new Scene(group, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void registerHandler(Shape s, Color defaultColor, Color hoverColor) {
        s.setOnMouseEntered( e -> s.setFill(hoverColor));
        s.setOnMouseExited(e -> s.setFill(defaultColor));
    }

}