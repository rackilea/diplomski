import java.util.concurrent.Callable;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.IndexRange;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RestrictedTextFieldExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        final TextField restrictedTextField = new TextField() {

            private final Pattern numberPattern = Pattern.compile("\\d{1,3}");
            @Override
            public void replaceText(int start, int end, String text) {
                if (valid(start, end, text)) {
                    super.replaceText(start, end, text);
                }
            }

            @Override
            public void replaceSelection(String text) {
                IndexRange selectionRange = getSelection();
                if (valid(selectionRange.getStart(), selectionRange.getEnd(), text)) {
                    super.replaceSelection(text);
                }
            }


            private boolean valid(int start, int end, String text) {
                String attemptedText = 
                        getText().substring(0, start)
                        + text
                        + getText().substring(end);
                if (attemptedText.length() == 0) {
                    return true ;
                }
                if (numberPattern.matcher(attemptedText).matches()) {
                    int value = Integer.parseInt(attemptedText);
                    if (value >= 0 && value <= 127) {
                        return true ;
                    }
                }
                return false ;
            }
        };

        IntegerProperty value = new SimpleIntegerProperty();
        value.bind(Bindings.createIntegerBinding(new Callable<Integer>(){

            @Override
            public Integer call() throws Exception {
                String text = restrictedTextField.getText();
                if (text.isEmpty()) {
                    return 0 ;
                } else {
                    return Integer.parseInt(text);
                }
            }

        }, restrictedTextField.textProperty()));

        value.addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                System.out.printf("Value changed from %d to %d%n", oldValue.intValue(), newValue.intValue());
            }

        });

        VBox root = new VBox(5);
        root.getChildren().add(restrictedTextField);
        Scene scene = new Scene(root, 250, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}