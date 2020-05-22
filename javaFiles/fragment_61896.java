import java.util.function.UnaryOperator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class AddingController {

    private final AddingModel model ;

    @FXML
    private TextField valueField ;

    @FXML
    private ListView<Integer> values ;

    @FXML
    private Label sum ;

    public AddingController(AddingModel model) {
        this.model = model ;
    }

    @FXML
    private void initialize() {
        values.setItems(model.getValues());
        sum.textProperty().bind(model.totalProperty().asString("Total = %,d"));

        // Allow only integer values in the text field:
        UnaryOperator<TextFormatter.Change> filter = c -> {
            if (c.getControlNewText().matches("-?[0-9]*")) {
                return c;
            } else {
                return null ;
            }
        };
        valueField.setTextFormatter(new TextFormatter<>(filter));
    }

    @FXML
    private void addValue() {
        String text = valueField.getText();
        if (! text.isEmpty()) {
            int value = Integer.parseInt(text);
            model.addValue(value);
            valueField.clear();
        }
    }

    @FXML
    private void clearValues() {
        model.clear();
    }
}