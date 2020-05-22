import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class BindToScrollingObject extends Application {


    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();
        ScrollPane scroller = new ScrollPane();
        VBox vbox = new VBox(20);
        scroller.setContent(vbox);
        Label bindingLabel = new Label("Binding here");
        for (int i = 0; i < 4; i++) {
            vbox.getChildren().add(new Label("Item "+(i+1)));
        }
        vbox.getChildren().add(bindingLabel);
        for (int i = 0; i < 4; i++) {
            vbox.getChildren().add(new Label("Item "+(i+6)));
        }
        Label anchor = new Label("Anchor");
        anchor.setStyle("-fx-background-color: antiquewhite");
        StackPane stack = new StackPane(anchor);

        root.getChildren().addAll(scroller, stack);

        Line line = new Line();
        line.setManaged(false);
        root.getChildren().add(line);

        ChangeListener<Object> listener = (obs, oldValue, newValue) -> 
            updateLine(line, anchor, bindingLabel);

        anchor.boundsInLocalProperty().addListener(listener);
        anchor.localToSceneTransformProperty().addListener(listener);
        bindingLabel.boundsInLocalProperty().addListener(listener);
        bindingLabel.localToSceneTransformProperty().addListener(listener);

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    private void updateLine(Line line, Node start, Node end) {

        Node target = line.getParent();

        Bounds startBounds = convertBoundsToTarget(start, target);
        Bounds endBounds = convertBoundsToTarget(end, target);


        line.setStartX(startBounds.getMinX() + startBounds.getWidth() / 2);
        line.setStartY(startBounds.getMinY() + startBounds.getHeight() / 2);
        line.setEndX(endBounds.getMinX() + endBounds.getWidth() / 2);
        line.setEndY(endBounds.getMinY() + endBounds.getHeight() / 2);
    }

    private Bounds convertBoundsToTarget(Node node, Node target) {
        Bounds boundsInScene = node.localToScene(node.getBoundsInLocal());
        return target.sceneToLocal(boundsInScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}