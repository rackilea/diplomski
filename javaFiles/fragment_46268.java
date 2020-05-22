import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Test extends Application {

    private Circle c1;
    private Circle c2;

    @Override
    public void start(Stage stage) throws Exception {

        AnchorPane pane = new AnchorPane();

        // Set only the radius
        c1 = new Circle(5);
        c1.setFill(Color.BLUE);

        // Let's translate the c1 to the location we want
        c1.setTranslateX(50);
        c1.setTranslateY(60);

        // The same for circle2
        c2 = new Circle(5);
        c2.setFill(Color.RED);

        c2.setTranslateX(120);
        c2.setTranslateY(200);

        pane.getChildren().addAll(c1, c2);

        pane.setOnMouseClicked(e -> {
            startAnimation();
        });

        stage.setScene(new Scene(pane, 400, 500));
        stage.show();
    }

    private void startAnimation() {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(c1);
        transition.setToX(c2.getTranslateX());
        transition.setToY(c2.getTranslateY());
        transition.setInterpolator(Interpolator.LINEAR);
        transition.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}