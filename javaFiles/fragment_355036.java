import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WindowInsetsDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label topLabel = new Label();
        Label leftLabel = new Label();
        Label rightLabel = new Label();
        Label bottomLabel = new Label();


        VBox root = new VBox(10, topLabel, leftLabel, bottomLabel, rightLabel);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 600, 400);


        ObjectBinding<Insets> insets = Bindings.createObjectBinding(() -> 
        new Insets(scene.getY(), 
                primaryStage.getWidth()-scene.getWidth() - scene.getX(), 
                primaryStage.getHeight()-scene.getHeight() - scene.getY(), 
                scene.getX()),
                scene.xProperty(),
                scene.yProperty(),
                scene.widthProperty(),
                scene.heightProperty(),
                primaryStage.widthProperty(),
                primaryStage.heightProperty()
            );

        topLabel.textProperty().bind(Bindings.createStringBinding(() -> "Top: "+insets.get().getTop(), insets));
        leftLabel.textProperty().bind(Bindings.createStringBinding(() -> "Left: "+insets.get().getLeft(), insets));
        rightLabel.textProperty().bind(Bindings.createStringBinding(() -> "Right: "+insets.get().getRight(), insets));
        bottomLabel.textProperty().bind(Bindings.createStringBinding(() -> "Bottom: "+insets.get().getBottom(), insets));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}