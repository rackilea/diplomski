package helloWorldFX;

import java.util.Map;

import javafx.scene.control.TextField;

public class Initialiser {

    private Map<TextField, String> values;

    public Initialiser(Map<TextField, String> mappedValues) {
        this.values = mappedValues;
    }

    String message;

    public String checker() {

        String errorField = values.entrySet().stream().filter(entry -> entry.getKey().getText().isBlank()).map(Map.Entry::getValue).findFirst().orElse(null);

        if (errorField != null) {
            return message = errorField + " blank!";
        } else {
            return message = "OK!";
        }

    }

}