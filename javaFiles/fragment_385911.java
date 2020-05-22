import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ArcTransitionTest extends Application {

    private final double xJumpRadius = 20 ;
    private final double yJumpRadius = 80 ;


    @Override
    public void start(Stage primaryStage) {
        Rectangle rect = new Rectangle(50, 200, 50, 100);
        rect.setFill(Color.CORNFLOWERBLUE);

        Button left = new Button("<");
        left.setOnAction(e -> jumpLeft(rect));

        Button right = new Button(">");
        right.setOnAction(e -> jumpRight(rect));

        HBox controls = new HBox(5, left, right);
        controls.setPadding(new Insets(10));
        controls.setAlignment(Pos.CENTER);

        Pane pane = new Pane(rect);
        BorderPane root = new BorderPane(pane, null, null, controls, null);
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    private void jumpRight(Rectangle rect) {
        jump(rect, 180, -180, getHorizontalCenter(rect) + xJumpRadius, getVerticalCenter(rect));
    }

    private void jumpLeft(Rectangle rect) {        
        jump(rect, 0, 180, getHorizontalCenter(rect) - xJumpRadius, getVerticalCenter(rect));
    }

    private void jump(Rectangle rect, double startAngle, double angularLength, double centerX, double centerY) {
        Arc arc = new Arc();
        arc.setCenterX(centerX);
        arc.setCenterY(centerY);
        arc.setRadiusX(xJumpRadius);
        arc.setRadiusY(yJumpRadius);
        arc.setStartAngle(startAngle);
        arc.setLength(angularLength);

        PathTransition transition = new PathTransition(Duration.seconds(1), arc, rect);

        transition.playFromStart();
    }

    private double getHorizontalCenter(Rectangle rect) {
        return rect.getX() + rect.getTranslateX() + rect.getWidth() / 2 ;
        // Alternatively:
        // Bounds b = rect.getBoundsInParent();
        // return (b.getMinX() + b.getMaxX()) / 2 ;
    }

    private double getVerticalCenter(Rectangle rect) {
        return rect.getY() + rect.getTranslateY() + rect.getHeight() / 2 ;
        // Alternatively:
        // Bounds b = rect.getBoundsInParent();
        // return (b.getMinY() + b.getMaxY()) / 2 ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}