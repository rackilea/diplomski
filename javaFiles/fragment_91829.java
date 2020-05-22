import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;

public class ClickListenerSample 
                 extends Application 
                 implements ClickScreenListener {

    private Label clickFeedbackLabel = new Label("");

    @Override public void start(Stage stage) {
        Button listen = new Button("listen");
        listen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new ClickScreen(ClickListenerSample.this);
            }
        });
        VBox layout = new VBox(10);
        layout.getChildren().setAll(
            listen,
            clickFeedbackLabel
        );
        layout.setPadding(new Insets(10));

        stage.setScene(new Scene(layout, 100, 80));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override public void screenClicked(Point2D point) {
        clickFeedbackLabel.setText(point.getX() + ", " + point.getY());
    }
}

interface ClickScreenListener {
    void screenClicked(Point2D point);
}

class ClickScreen {
    private ClickScreenListener listener;
    private Stage window;
    private Point2D point;

    public ClickScreen(ClickScreenListener listener) {
        // Get screen size
        Rectangle2D r = Screen.getPrimary().getBounds();

        // Something to put stuff in
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: null;");

        // Translucent rectangle on the pane
        Rectangle rectangle = new Rectangle(r.getWidth(), r.getHeight());
        rectangle.setFill(Color.rgb(183, 183, 183, 0.5));
        root.getChildren().add(rectangle);

        Scene scene = new Scene(root, r.getWidth(), r.getHeight());
        scene.setFill(null);

        window = new Stage();
        window.initStyle(StageStyle.TRANSPARENT);
        window.setTitle("Click drop location");
        window.setScene(scene);

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                point = new Point2D(event.getScreenX(), event.getScreenY());
                listener.screenClicked(point);
                window.hide();
            }
        });

        window.show();

        this.listener = listener;
    }

    public Point2D getLocation(){
        return point;
    }
}