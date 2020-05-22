import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    Pane pane = new Pane();
    pane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
    pane.setMaxSize(500, 300);

    Rectangle rect = new Rectangle(100, 100, Color.FIREBRICK);
    rect.setOnMousePressed(this::handleMousePressed);
    rect.setOnMouseDragged(this::handleMouseDragged);
    pane.getChildren().add(rect);

    StackPane root = new StackPane(pane);

    primaryStage.setScene(new Scene(root, 600, 400));
    primaryStage.show();
  }

  private Point2D origin;

  private void handleMousePressed(MouseEvent event) {
    origin = new Point2D(event.getX(), event.getY());
    event.consume();
  }

  private void handleMouseDragged(MouseEvent event) {
    Rectangle rect = (Rectangle) event.getSource();
    rect.setTranslateX(rect.getTranslateX() + event.getX() - origin.getX());
    rect.setTranslateY(rect.getTranslateY() + event.getY() - origin.getY());
    event.consume();
  }

}