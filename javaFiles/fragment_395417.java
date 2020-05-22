import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


public class City extends Rectangle {

    public City(final Node node) {
        super(node.getLayoutX(), node.getLayoutY(), 32, 32);
        this.setFill(Paint.valueOf("BLUE"));
    }

}