import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class ClickablePolygonApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[] {
                0., 80.,
                80., 80.,
                40., 20.
        });

        StackPane stackPane = new StackPane(polygon);
        stackPane.setPrefSize(400., 400.);

        stage.setScene(new Scene(stackPane));
        stage.show();

        polygon.setOnMouseClicked(mouseEvent -> System.out.println("1st way to handle Click!"));
        polygon.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> System.out.println("2nd way to handle click!"));
    }
}