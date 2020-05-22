import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Clicker extends Application {

    @Override
    public void start(Stage inputStage) throws Exception {
        final ClickCounter clickCounter = new ClickCounter();

        final ClickInputView  inputView  = new ClickInputView(clickCounter);
        final ClickOutputView outputView = new ClickOutputView(clickCounter);

        inputStage.setScene(new Scene(inputView));
        inputStage.show();

        Stage outputStage = new Stage();
        outputStage.initOwner(inputStage);
        outputStage.initStyle(StageStyle.UTILITY);
        outputStage.setScene(new Scene(outputView));
        outputStage.setX(inputStage.getX());
        outputStage.setY(inputStage.getY() + inputStage.getHeight());
        outputStage.show();
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
            setPadding(new Insets(10));

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
            setPadding(new Insets(10));

            getChildren().setAll(clickCountLabel);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}