import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LastActionTrackingDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button apples = new Button("Apples");
        Button oranges = new Button("Oranges");
        Button pears = new Button("Pears");

        ObjectProperty<Button> lastActionedButton = new SimpleObjectProperty<>();

        EventHandler<ActionEvent> buttonActionHandler = event -> 
            lastActionedButton.set((Button) event.getSource());

        apples.addEventHandler(ActionEvent.ACTION, buttonActionHandler);
        oranges.addEventHandler(ActionEvent.ACTION, buttonActionHandler);
        pears.addEventHandler(ActionEvent.ACTION, buttonActionHandler);

        lastActionedButton.addListener((obs, oldButton, newButton) -> 
            System.out.println("Button changed from "+oldButton+" to "+newButton));

        HBox root = new HBox(5, apples, oranges, pears);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 350, 75);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}