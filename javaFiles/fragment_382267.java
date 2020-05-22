import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Clicker extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        final ClickCounter clickCounter = new ClickCounter();

        final ClickInputView  inputView  = new ClickInputView(clickCounter);
        final ClickOutputView outputView = new ClickOutputView(clickCounter);

        VBox layout = new VBox(10,
                inputView,
                outputView
        );
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(layout));
        stage.show();
    }

    private class ClickCounter {
        private final ReadOnlyIntegerWrapper numClicks =
                new ReadOnlyIntegerWrapper(0);

        public int getNumClicks() {
            return numClicks.get();
        }

        public ReadOnlyIntegerProperty numClicksProperty() {
            return numClicks.getReadOnlyProperty();
        }

        public void click() {
            numClicks.set(getNumClicks() + 1);
        }
    }

    private class ClickInputView extends StackPane {
        private final Button button = new Button("Click Me!");

        public ClickInputView(ClickCounter clickCounter) {
            button.setOnAction(event -> clickCounter.click());

            getChildren().setAll(button);
        }
    }

    private class ClickOutputView extends StackPane {
        private final Label clickCountLabel = new Label();

        public ClickOutputView(ClickCounter clickCounter) {
            clickCountLabel.textProperty().bind(
                    Bindings.format(
                            "Clicked %d times",
                            clickCounter.numClicksProperty()
                    )
            );
            clickCountLabel.setMinWidth(150);
            clickCountLabel.setAlignment(Pos.CENTER);

            getChildren().setAll(clickCountLabel);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}