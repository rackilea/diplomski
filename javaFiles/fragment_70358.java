import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StyleDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField txt = new TextField("text");
        txt.setLayoutY(150);
        txt.setPrefHeight(50);
        txt.setStyle("-fx-background-color: rgb(0,0,0,0.11); -fx-text-fill: white; -fx-font-size: 28; -fx-font-weight: bold");

        Pane root = new Pane();
        root.setStyle("-fx-background-image: url(\"http://i.stack.imgur.com/ThghN.png\"); -fx-background-repeat: stretch; -fx-background-size: 300 250;");
        root.getChildren().add(txt);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}