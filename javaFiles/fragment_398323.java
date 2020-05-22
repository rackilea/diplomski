import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerA implements EventHandler {
    private final Stage primaryStage;
    private final ViewA view = new ViewA(this);

    public ControllerA(final Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(final Event event) {
        final Object source = event.getSource();

        if (source.equals(view.getButton())) {
            System.out.println("ButtonA has been pressed, switching to ViewB.");

            final ControllerB controllerB = new ControllerB(primaryStage);
            final Scene scene = new Scene(controllerB.getView());
            primaryStage.setScene(scene);
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ViewA getView() {
        return view;
    }
}