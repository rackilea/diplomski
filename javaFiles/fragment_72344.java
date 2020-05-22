import java.io.IOException;
import java.io.UncheckedIOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class SteeringWheel extends Pane {

  @FXML private Label myLabel;
  @FXML private Circle innerCircle;
  @FXML private Circle backgroundCircle;

  public SteeringWheel() {
    FXMLLoader loader = new FXMLLoader(/* location */);
    loader.setRoot(this);
    loader.setController(this);
    try {
      loader.load();
    } catch (IOException ex) {
      throw new UncheckedIOException(ex);
    }
  }

  @FXML
  private void initialize() {
    // perform any initialization, if needed
  }

  @Override
  public void layoutChildren() {
    // Note: I didn't implement checking if the nodes are managed
    //       before laying them out. You may wish to add that
    //       behavior.


    // The following will always keep the Circles in the center
    // of the Pane. However, it does this by setting the layout[X|Y]
    // properties rather than the center[X|Y] properties (as you're
    // doing).
    double x = snappedLeftInset();
    double y = snappedTopInset();
    double w = getWidth() - snappedRightInset() - x;
    double h = getHeight() - snappedBottomInset() - y;

    positionInArea(innerCircle, x, y, w, h, -1, HPos.CENTER, VPos.CENTER);
    positionInArea(backgroundCircle, x, y, w, h, -1, HPos.CENTER, VPos.CENTER);

    // Layout the Label in the top-left corner
    layoutInArea(myLabel, x, y, w, h, -1, HPos.LEFT, VPos.TOP);
  }
}