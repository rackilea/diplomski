import javafx.stage.Stage;

public class ControllerB {
    private final Stage primaryStage;
    private final ViewB view = new ViewB(this);

    public ControllerB(final Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ViewB getView() {
        return view;
    }
}