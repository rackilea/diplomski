import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
...

TextField tpo = ...;
tpo.setTextFormatter(new TextFormatter<>((change) -> {
        String text = change.getControlNewText();
        if (text.matches("\\d*\\.?\\d*")) {
            return change;
        } else {
            return null;
        }
    }));