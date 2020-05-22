import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private GridPane gridPane;
    @FXML
    private Button btnGetInputText;

    // List of new TextInput objects
    List<TextInput> textInputs = new ArrayList<>();

    @FXML
    private void initialize() {

        // Here we will generate 40 new TextInput objects.
        for (int i = 0; i < 40; i++) {
            TextInput input = new TextInput(
                    "Input " + i,
                    new Label("Input " + i + ":"),
                    new TextField()
            );

            // Now, add the new TextInput Label and TextField to the GridPane
            gridPane.add(input.getLabel(), 0, i);
            gridPane.add(input.getTextField(), 1, i);

            // Finally, add the input to the list so they can be retrieved later using the input's Name
            textInputs.add(input);
        }

        // Use the button to print out the text from Input #4
        btnGetInputText.setOnAction(e -> {
            System.out.println("Input #4: " + getInputTextByName("Input 4"));
        });
    }

    /**
     * Helper method to get the value of a specific TextField
     */
    private String getInputTextByName(String name) {

        // Loop through the list of TextInput objects and get the one with the desired name
        for (TextInput input :
                textInputs) {
            if (input.getName().equalsIgnoreCase(name)) {
                return input.getTextField().getText();
            }
        }

        // If not found, return null (or empty String, if desired)
        return null;

    }
}

/**
 * Custom data structure to hold both the Label and TextFields for your inputs. There is also a Name field that can
 * be any type you wish, but provides a way of locating the right TextField when you need to. This could just as
 * easily be done with an ID or searching label.getText(), but I'm using a separate field in this sample for simplicity.
 */
class TextInput {

    private final String name;
    private final Label label;
    private final TextField textField;

    public TextInput(String name, Label label, TextField textField) {
        this.name = name;
        this.label = label;
        this.textField = textField;
    }

    public String getName() {
        return name;
    }

    public Label getLabel() {
        return label;
    }

    public TextField getTextField() {
        return textField;
    }
}