import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DragAndDrop extends Application {
    private static final DataFormat DRAGGABLE_HBOX_TYPE = new DataFormat("draggable-hbox");

    @Override
    public void start(Stage stage) {
        VBox content = new VBox(5);

        for (int i = 0; i < 10; i++) {
            Label label = new Label("Test drag");

            DraggableHBox box = new DraggableHBox();
            box.getChildren().add(label);

            content.getChildren().add(box);
        }

        stage.setScene(new Scene(content));
        stage.show();
    }

    class DraggableHBox extends HBox {
        public DraggableHBox() {
            this.setOnDragDetected(e -> {
                Dragboard db = this.startDragAndDrop(TransferMode.MOVE);

                // This is where the magic happens, you take a snapshot of the HBox.
                db.setDragView(this.snapshot(null, null));

                // The DragView wont be displayed unless we set the content of the dragboard as well. 
                // Here you probably want to do more meaningful stuff than adding an empty String to the content.
                ClipboardContent content = new ClipboardContent();
                content.put(DRAGGABLE_HBOX_TYPE, "");
                db.setContent(content);

                e.consume();
            });
        }
    }

    public static void main(String[] args) {
        launch();
    }
}