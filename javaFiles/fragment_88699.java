package application;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    private final IntegerProperty counter = new SimpleIntegerProperty(1);

    @FXML
    private Label label ;

    public void initialize() throws Exception {
        label.textProperty().bind(Bindings.format("Count: %s", counter));

        // uncomment the next line to demo exceptions in the start() method:
        // throw new Exception("Initializer exception");
    }

    @FXML
    private void safeHandler() {
        counter.set(counter.get()+1);
    }

    @FXML
    private void riskyHandler() throws Exception {
        if (Math.random() < 0.5) {
            throw new RuntimeException("An unknown error occurred");
        }
        safeHandler();
    }
}