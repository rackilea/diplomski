import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import com.sun.javafx.scene.control.skin.TextAreaSkin;

// Parts of this drag/drop example are from https://docs.oracle.com/javafx/2/drag_drop/HelloDragAndDrop.java.html
public class TextAreaDemo extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Label source = new Label( "Draggable Text");

        TextArea target = new TextArea();
        target.setPrefRowCount(10);
        target.setPrefColumnCount(100);
        target.setWrapText(true);
        target.setPrefWidth(150);

        String cssDefault = "Lorem ipsum dolor sit amet, et bonorum pertinacia est, verear temporibus definitionem nam an, ius cu justo legimus philosophia. Adversarium complectitur at sit, his ex sumo nibh consequuntur. Et vim adhuc mnesarchum, eum in ignota integre tincidunt. Erant oblique alterum no eos.";

        target.setText(cssDefault);

        HBox root = new HBox();
        root.setSpacing(10);
        HBox.setMargin(source, new Insets(10,10,10,10));
        HBox.setMargin(target, new Insets(10,10,10,10));
        root.getChildren().addAll( source, target);

        Scene scene = new Scene(root, 600, 330, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();

        source.setOnDragDetected(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {

                /* allow any transfer mode */
                Dragboard db = source.startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putString(source.getText());
                db.setContent(content);

                event.consume();
            }
        });

        target.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {

                /* accept it only if it is  not dragged from the same node 
                 * and if it has a string data */
                if (event.getGestureSource() != target &&
                        event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);

                    // position caret at drag coordinates 
                    TextAreaSkin skin = (TextAreaSkin) target.getSkin();
                    int insertionPoint = skin.getInsertionPoint(event.getX(),  event.getY());
                    target.positionCaret( insertionPoint);

                }

                event.consume();
            }
        });

        target.setOnDragDropped(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {

                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    target.insertText( target.getCaretPosition(), db.getString());
                    success = true;
                }
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);
                event.consume();
            }
        });
    }
}