import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IdForControlsOnClick extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox(20);
        borderPane.setCenter(vBox);

        Button button = new Button("Hi");
        button.setId("Button");
        Label label = new Label("Label");
        label.setId("Label");
        CheckBox checkBox = new CheckBox();
        checkBox.setId("CheckBox");

        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
        label.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
        checkBox.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());

        vBox.getChildren().addAll(button, label, checkBox);
        Scene scene = new Scene(borderPane, 200, 200);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private class MyEventHandler implements EventHandler<Event>{
        @Override
        public void handle(Event evt) {
           System.out.println(((Control)evt.getSource()).getId());
        }
    }
}