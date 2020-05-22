import java.util.ArrayList;

import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestApplication extends Application {

    private boolean addedBySelection = false;
    private ArrayList<String> tagList = new ArrayList<>();
    private FlowPane tagPane;

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox mainPane = new VBox(10);
        mainPane.setStyle("-fx-background-color : white");
        mainPane.setPadding(new Insets(15));
        mainPane.setAlignment(Pos.CENTER);

        tagPane = new FlowPane(15, 10);
        tagPane.setPrefHeight(50);

        CustomTextField field = new CustomTextField() {
            @Override
            public void paste() {
                super.paste();
                addedBySelection = false;
            }
        };

        field.setOnKeyPressed(e -> {
            addedBySelection = false;
        });

        field.setOnKeyReleased(e -> {
            addedBySelection = true;
        });

        field.textProperty().addListener(e -> {
            if (addedBySelection) {
                System.out.println("Text Changed from the suggession list ");
                addTag(field.getText());

                addedBySelection = false;
                field.clear();
                addedBySelection = true;
            } else {
                System.out.println("User Input (Mouse paste, or typing) ");
            }
        });

        TextFields.bindAutoCompletion(field, new String[] { "Java", "C++", "C#", "Python", "Haskell" });

        mainPane.getChildren().addAll(field, tagPane);

        Scene scene = new Scene(mainPane, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addTag(String tag) {
        if (!tagList.contains(tag)) {
            tagList.add(tag);
            Label tagLabel = new Label(tag);
            tagLabel.setStyle("-fx-background-color : #E1ECF4; -fx-text-fill : #6A739D;");
            tagPane.getChildren().add(tagLabel);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}