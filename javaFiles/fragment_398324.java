import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ViewA extends HBox {
    private final Button button = new Button("ButtonA");

    public ViewA(final ControllerA controllerA) {
        button.setOnAction(controllerA);
        this.getChildren().addAll(button);
    }

    public Button getButton() {
        return button;
    }
}