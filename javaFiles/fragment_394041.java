package be.dupirefr.pebblefx;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

import be.dupirefr.pebblefx.controllers.DumbController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PebbleEngine engine = new PebbleEngine.Builder().build();
        PebbleTemplate compiledTemplate = engine.getTemplate("templates/Index.pebble.fxml");

        Map<String, Object> context = new HashMap<>();

        File file = File.createTempFile("views/Index", "fxml");
        file.deleteOnExit();

        PrintWriter writer = new PrintWriter(file);
        compiledTemplate.evaluate(writer, context);
        writer.close();

        primaryStage.setTitle("Pebble test");

        FXMLLoader loader = new FXMLLoader();

        loader.setController(new DumbController());
        loader.setLocation(file.toURI().toURL());

        BorderPane pane = loader.load();
        Scene scene = new Scene(pane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}