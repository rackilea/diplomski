package helloWorldFX;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class MainController {

    @FXML   private TextField one;
    @FXML   private TextField two;
    @FXML   private TextField three;

    @FXML   private TextArea outputMessage;

    public void run(ActionEvent event) {

        Map<TextField, String> testMap = new LinkedHashMap<>();

        testMap.put(one,"a");
        testMap.put(two,"b");
        testMap.put(three,"c");

        Initialiser initialiser = new Initialiser(testMap);

        outputMessage.setText(initialiser.checker());

    }

}