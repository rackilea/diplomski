import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class NonBlurryPane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox pane = new VBox();

        pane.setPrefSize(500, 500);

        Scene scene = new Scene(pane);

        ScrollPane scroll = new ScrollPane();
        StackPane scrollContainer = new StackPane(scroll);
        VBox.setVgrow(scrollContainer, Priority.ALWAYS);

        // Center ScrollPane
        scroll.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        scroll.setPrefSize(200, 200);
        scroll.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        ListView<String> list = new ListView<>();
        scroll.setContent(list);

        list.getItems().addAll("Resize the window", "and see how this list", "does NOT become blurry");

        // Label indicates x, y coords of ScrolPane and their ratio.
        TextField size = new TextField();
        size.setMaxWidth(Double.MAX_VALUE);
        size.setMinHeight(Region.USE_PREF_SIZE);
        size.textProperty().bind(
                scroll.layoutXProperty()
                        .asString("x: %s; ").concat(
                        scroll.layoutYProperty()
                                .asString("y: %s; ")).concat(
                        scroll.layoutXProperty().divide(scroll.layoutYProperty())
                                .asString("x/y: %s; ")).concat(
                        scroll.layoutYProperty().divide(scroll.layoutXProperty())
                                .asString("y/x: %s")));

        pane.getChildren().addAll(size, scrollContainer);

        stage.setScene(scene);
        stage.show();
    }
}