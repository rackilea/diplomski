package com.grs.stackOverFlow.pack161124;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class ChatBox extends Application{
    final ScrollPane sp = new ScrollPane();
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage stage){
        TextFlow textFlow = new TextFlow();
        //textFlow.setPadding(new Insets(10));
        textFlow.setLineSpacing(10);
        //textFlow.setPrefSize(300,300);
        TextField textField = new TextField();
        textField.setPrefSize(50,30);
        Button button = new Button("Send");
        button.setPrefSize(80,30);
        VBox container = new VBox();
        VBox box = new VBox();
        box.getChildren().addAll(sp,textFlow);
        container.setPadding(new Insets(10));
        container.getChildren().addAll(box, new HBox(textField, button));
        VBox.setVgrow(sp, Priority.ALWAYS);
        VBox.setVgrow(textFlow, Priority.ALWAYS);
        textField.prefWidthProperty().bind(container.widthProperty().subtract(button.prefWidthProperty()));

        // On Enter press
        textField.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER) {
                button.fire();
            }
        });

        button.setOnAction(e -> {
            Text text;
            if(textFlow.getChildren().size()==0){
                text = new Text(textField.getText());
            } else {
                // Add new line if not the first child
                text = new Text("\n" + textField.getText());
            }
            textFlow.getChildren().add(text);
            textField.clear();
            textField.requestFocus();
        });
        VBox vb = new VBox();
        vb.getChildren().addAll(textFlow);
        sp.setVmax(440);
        sp.setPrefSize(400, 300);
        sp.setContent(vb);
        sp.vvalueProperty().bind((ObservableValue<? extends Number>) vb.heightProperty());
        //sp.setPannable(true);
        Scene scene = new Scene(container, 400, 300);
        stage.setScene(scene);
        stage.setTitle("ChatBox");
        stage.show();
    }
}

[![enter image description here][1]][1]