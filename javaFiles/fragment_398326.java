import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ViewB extends HBox {
    private final Button button = new Button("ButtonB");

    public ViewB(final ControllerB controllerB) {
        button.setOnAction(event -> {
            System.out.println("ButtonB has been pressed, switching to ViewA.");

            final Stage primaryStage = controllerB.getPrimaryStage();
            final ControllerA controllerA = new ControllerA(primaryStage);
            final Scene scene = new Scene(controllerA.getView());
            primaryStage.setScene(scene);
        });
        this.getChildren().addAll(button);
    }

    public Button getButton() {
        return button;
    }
}