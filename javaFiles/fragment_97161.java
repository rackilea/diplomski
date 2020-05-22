import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ConstrainedWindow extends Application {

    @Override
    public void start(Stage primaryStage) {

        Bounds allScreenBounds = computeAllScreenBounds();
        ChangeListener<Number> boundsListener = (obs, oldValue, newValue) -> {
            double x = primaryStage.getX();
            double y = primaryStage.getY();
            double w = primaryStage.getWidth();
            double h = primaryStage.getHeight();
            if (x < allScreenBounds.getMinX()) {
                primaryStage.setX(allScreenBounds.getMinX());
            }
            if (x + w > allScreenBounds.getMaxX()) {
                primaryStage.setX(allScreenBounds.getMaxX() - w);
            }
            if (y < allScreenBounds.getMinY()) {
                primaryStage.setY(allScreenBounds.getMinY());
            }
            if (y + h > allScreenBounds.getMaxY()) {
                primaryStage.setY(allScreenBounds.getMaxY() - h);
            }
        };
        primaryStage.xProperty().addListener(boundsListener);
        primaryStage.yProperty().addListener(boundsListener);
        primaryStage.widthProperty().addListener(boundsListener);
        primaryStage.heightProperty().addListener(boundsListener);
        primaryStage.show();
    }

    private Bounds computeAllScreenBounds() {
        double minX = Double.POSITIVE_INFINITY ;
        double minY = Double.POSITIVE_INFINITY ;
        double maxX = Double.NEGATIVE_INFINITY ;
        double maxY = Double.NEGATIVE_INFINITY ;
        for (Screen screen : Screen.getScreens()) {
            Rectangle2D screenBounds = screen.getBounds();
            if (screenBounds.getMinX() < minX) {
                minX = screenBounds.getMinX();
            }
            if (screenBounds.getMinY() < minY) {
                minY = screenBounds.getMinY() ;
            }
            if (screenBounds.getMaxX() > maxX) {
                maxX = screenBounds.getMaxX();
            }
            if (screenBounds.getMaxY() > maxY) {
                maxY = screenBounds.getMaxY() ;
            }
        }
        return new BoundingBox(minX, minY, maxX-minX, maxY-minY);
    }

    public static void main(String[] args) {
        launch(args);
    }
}