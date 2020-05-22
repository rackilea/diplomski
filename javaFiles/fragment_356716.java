import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private StringProperty textRecu = new SimpleStringProperty();
    private TextArea consoleTextArea = new TextArea();

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();

        Button button = new Button("Add some text");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //here you change textRecu and not consoleTextArea.textProperty()
                textRecu.setValue(textRecu.getValue() +"New Line\n");
            }
        });

        root.getChildren().addAll(consoleTextArea, button);
        consoleTextArea.textProperty().bind(textRecu);

        //here you also add listener to the textRecu 
        textRecu.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue,
                                Object newValue) {
                // from stackoverflow.com/a/30264399/1032167
                // for some reason setScrollTop will not scroll properly
                //consoleTextArea.setScrollTop(Double.MAX_VALUE);
                  consoleTextArea.selectPositionCaret(consoleTextArea.getLength()); 
                  consoleTextArea.deselect(); 
            }
        });

        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}