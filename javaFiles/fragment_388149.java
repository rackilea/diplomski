import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;

// java 8
// click on the scene to place a shaded lens effect over the scene.
public class ShadedScene extends Application {
    @Override
    public void start(Stage stage) {
        StackPane layout = new StackPane(
                new Label("Click to shade/unshade")
        );
        layout.setPrefSize(400, 300);

        Scene scene = new Scene(layout);
        makeShadeable(scene);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Applies a lens effect gradient to a scene root node.
     * The effect is kind of like a flashlight shining against the wall in the dark.
     *
     * For the gradient to be applied, the scene's root must be defined and a Pane
     * to which the effect can added and removed as a child.
     * 
     * @param scene the scene to have the effect applied.
     */
    private void makeShadeable(Scene scene) {
        if (scene.getRoot() == null ||
            !(scene.getRoot() instanceof Pane)) {
            return;
        }

        Pane shade = new Pane();
        RadialGradient shadePaint = new RadialGradient(
                0, 0, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE,
                new Stop(1, Color.BLACK),
                new Stop(0, Color.TRANSPARENT)
        );

        shade.setBackground(
                new Background(
                        new BackgroundFill(
                                shadePaint, null, new Insets(-10)
                        )
                )
        );

        // blur helps reduce visible banding of the radial gradient.
        shade.setEffect(new BoxBlur(5, 5, 3));

        Pane root = (Pane) scene.getRoot();
        scene.setOnMouseClicked(event -> {
            if (root.getChildren().contains(shade)) {
                root.getChildren().remove(shade);
            } else {
                root.getChildren().add(shade);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}