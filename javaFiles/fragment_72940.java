import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StageTest extends Application{

    private static final double WIDTH = 900, HEIGHT = 500;
    private Stage stage;
    private VBox root;
    boolean isVertical = false;

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;
        stage.setTitle("Dynamic Stage Resize");

        root = new VBox();
        root.setAlignment(Pos.CENTER_LEFT);
        root.setPrefSize(WIDTH, HEIGHT);

        Button addNode = new Button("Change Size");
        addNode.setOnAction( e -> changeSize());
        root.getChildren().add(addNode);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    void changeSize() {

        if(isVertical) {
            root.setPrefSize(WIDTH, HEIGHT);
        } else {
            root.setPrefSize(HEIGHT, WIDTH);
        }

        isVertical = !isVertical;
        stage.sizeToScene();
    }

    public static void main(String[] args) {
        launch(args);
    }
}