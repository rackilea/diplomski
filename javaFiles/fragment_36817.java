import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CharByCharGrabbing extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // create simple root and add two text fields to it
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        // just styling
        root.setBackground(new Background(new BackgroundFill(Color.MAGENTA, null,null)));

        TextField textField = new TextField();
        TextField textField1 = new TextField();

        root.getChildren().addAll(textField, textField1);

        Scene scene = new Scene(root, 300,200);
        stage.setScene(scene);
        stage.setTitle("Grabbing Char by Char");
        stage.show();

        // Now you can add a change listener to the text property of the text field
        // it will keep you updated with every single change (char by char)
        // either adding to or removing from the TextField
        textField.textProperty().addListener((observable, oldText, newText)->{ // lambda style
            textField1.setText(newText); // update me when any change happens
            // so you can grab the changes from here.
        });

    }

    public static void main(String[] args) {
        launch();
    }
}