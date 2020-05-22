import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author sedj601
 */
public class FXMLDocumentController implements Initializable {

    @FXML private Label lblMain;
    @FXML private Polygon polyOne, polyTwo;    
    @FXML private Circle circle1;
    @FXML private Rectangle rectangle1;

    final ObjectProperty<Point2D> mousePosition = new SimpleObjectProperty<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        polyOne.setOnMousePressed((MouseEvent event) -> {
            mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));
        });

        polyOne.setOnMouseDragged((MouseEvent event) -> {
            double deltaX = event.getSceneX() - mousePosition.get().getX();
            double deltaY = event.getSceneY() - mousePosition.get().getY();
            polyOne.setLayoutX(polyOne.getLayoutX()+deltaX);
            polyOne.setLayoutY(polyOne.getLayoutY()+deltaY);
            mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));

            Shape intersect = Shape.intersect(polyOne, polyTwo);

            if(intersect.getBoundsInLocal().getWidth() != -1)
            {
                System.out.println("This object can overlap other the other object!");
                lblMain.setText("Collision detected!");
            }
            else
            {
                intersect.getBoundsInLocal().getWidth();
                lblMain.setText("Collision not detected!");
            }            
        });

        polyTwo.setOnMousePressed((MouseEvent event) -> {
            mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));
        });

        polyTwo.setOnMouseDragged((MouseEvent event) -> {
            double deltaX = event.getSceneX() - mousePosition.get().getX();
            double deltaY = event.getSceneY() - mousePosition.get().getY();
            polyTwo.setLayoutX(polyTwo.getLayoutX() + deltaX);
            polyTwo.setLayoutY(polyTwo.getLayoutY() + deltaY);
            mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));

            Shape intersect = Shape.intersect(polyOne, polyTwo);
            {
                if(intersect.getBoundsInLocal().getWidth() != -1)
                {      
                    System.out.println("This object can not overlap other the other object!");
                    polyTwo.setLayoutX(polyTwo.getLayoutX() - deltaX);
                    polyTwo.setLayoutY(polyTwo.getLayoutY() - deltaY);
                    lblMain.setText("Collision detected!");
                }
                else
                {
                    lblMain.setText("Collision not detected!");
                }
            }
        });   

        circle1.setOnMousePressed((MouseEvent event) -> {
            mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));
        });

        circle1.setOnMouseDragged((MouseEvent event) -> {
            double deltaX = event.getSceneX() - mousePosition.get().getX();
            double deltaY = event.getSceneY() - mousePosition.get().getY();
            circle1.setLayoutX(circle1.getLayoutX() + deltaX);
            circle1.setLayoutY(circle1.getLayoutY() + deltaY);
            mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));

            Shape intersect = Shape.intersect(rectangle1, circle1);
            {
                if(intersect.getBoundsInLocal().getWidth() != -1)
                {      
                    System.out.println("This object can not overlap other the other object!");
                    circle1.setLayoutX(circle1.getLayoutX() - deltaX);
                    circle1.setLayoutY(circle1.getLayoutY() - deltaY);
                    lblMain.setText("Collision detected!");
                }
                else
                {
                    lblMain.setText("Collision not detected!");
                }
            }
        });   


        rectangle1.setOnMousePressed((MouseEvent event) -> {
            mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));
        });

        rectangle1.setOnMouseDragged((MouseEvent event) -> {
            double deltaX = event.getSceneX() - mousePosition.get().getX();
            double deltaY = event.getSceneY() - mousePosition.get().getY();
            rectangle1.setLayoutX(rectangle1.getLayoutX() + deltaX);
            rectangle1.setLayoutY(rectangle1.getLayoutY() + deltaY);
            mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));

            Shape intersect = Shape.intersect(circle1, rectangle1);
            {
                if(intersect.getBoundsInLocal().getWidth() != -1)
                {      
                    System.out.println("This object can not overlap other the other object!");
                    rectangle1.setLayoutX(rectangle1.getLayoutX() - deltaX);
                    rectangle1.setLayoutY(rectangle1.getLayoutY() - deltaY);
                    lblMain.setText("Collision detected!");
                }
                else
                {
                    lblMain.setText("Collision not detected!");
                }
            }
        });   
    }
}