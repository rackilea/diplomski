import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class OpenResourceNatively extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField("http://stackoverflow.com/questions/39898704");
        Button openURLButton = new Button("Open URL");
        EventHandler<ActionEvent> handler = e -> open(textField.getText());
        textField.setOnAction(handler);
        openURLButton.setOnAction(handler);

        FileChooser fileChooser = new FileChooser();
        Button openFileButton = new Button("Open File...");
        openFileButton.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                open(file.toURI().toString());
            }
        });

        VBox root = new VBox(5, 
                new HBox(new Label("URL:"), textField, openURLButton),
                new HBox(openFileButton)
        );

        root.setPadding(new Insets(20));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void open(String resource) {
        getHostServices().showDocument(resource);
    }

    public static void main(String[] args) {
        launch(args);
    }
}