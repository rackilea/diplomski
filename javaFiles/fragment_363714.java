import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.css.PseudoClass;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SelectableBoxes extends Application {

    private static final PseudoClass SELECTED_PSEUDOCLASS = PseudoClass.getPseudoClass("selected");

    private ObjectProperty<Pane> selectedBox = new SimpleObjectProperty<>();


    @Override
    public void start(Stage primaryStage) {
        VBox container = new VBox(5);
        container.setPadding(new Insets(20));

        int numBoxes = 5 ;
        for (int i = 0 ; i < numBoxes; i++) {
            container.getChildren().add(createBox());
        }
        ScrollPane scroller = new ScrollPane(container);
        Scene scene = new Scene(scroller, 400, 400);
        scene.getStylesheets().add("selectable-boxes.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Pane createBox() {
        Pane pane = new Pane();
        pane.setMinSize(50, 50);
        pane.getStyleClass().add("box");

        pane.setOnMouseClicked(e -> selectedBox.set(pane));

        selectedBox.addListener((obs, oldSelection, newSelection) -> 
            pane.pseudoClassStateChanged(SELECTED_PSEUDOCLASS, newSelection == pane));

        return pane ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}