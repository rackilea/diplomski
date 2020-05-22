import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class ImageViewer extends Application {

    private static final int IMAGE_SIZE = 160 ;

    @Override
    public void start(Stage primaryStage) {
        TilePane imagePane = new TilePane();
        imagePane.setHgap(5);
        imagePane.setVgap(5);

        imagePane.setOnDragOver(event -> {
            Dragboard db = event.getDragboard();
            if (db.hasImage() || db.hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY);
            }
        });

        imagePane.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            if (db.hasImage()) {
                ImageView imageView = new ImageView(db.getImage());
                imageView.setFitHeight(IMAGE_SIZE);
                imageView.setFitWidth(IMAGE_SIZE);
                imageView.setPreserveRatio(true);
                imagePane.getChildren().add(imageView);
                event.setDropCompleted(true);
            } else if (db.hasFiles()) {
                db.getFiles().forEach(file -> {
                    try {
                        Image image = new Image(file.toURI().toURL().toExternalForm(), IMAGE_SIZE, IMAGE_SIZE, true, true);
                        ImageView imageView = new ImageView(image);
                        imagePane.getChildren().add(imageView);
                    } catch (Exception exc) {
                        System.out.println("Could not load image "+file);
                    }
                });
                event.setDropCompleted(true);
            }
        });

        ScrollPane scroller = new ScrollPane();
        scroller.setContent(imagePane);

        imagePane.minHeightProperty().bind(Bindings.createDoubleBinding(() -> 
            scroller.getViewportBounds().getHeight(), 
            scroller.viewportBoundsProperty()));
        scroller.setFitToWidth(true);
        BorderPane root = new BorderPane(scroller, new Label("Drag images to pane below"), null, null, null);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}