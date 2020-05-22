import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        primaryStage.setWidth(800);
        primaryStage.setHeight(800);

        ChangeListener<Number> listener = new ChangeListener<Number>() {
            private Point2D stageSize = null ;
            private Point2D previousStageSize = new Point2D(primaryStage.getWidth(), primaryStage.getHeight());
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                if (stageSize == null) {
                    Platform.runLater(() -> {
                        System.out.printf("Old: (%.1f, %.1f); new: (%.1f, %.1f)%n", 
                                previousStageSize.getX(), previousStageSize.getY(), 
                                stageSize.getX(), stageSize.getY());
                        previousStageSize = stageSize;
                        stageSize = null;
                    });
                }
                stageSize = new Point2D(primaryStage.getWidth(), primaryStage.getHeight());                
            }


        };

        primaryStage.widthProperty().addListener(listener);
        primaryStage.heightProperty().addListener(listener);


        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
    }
}