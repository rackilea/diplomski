package org.jamesd.fxtest;

import java.net.URL;

import org.jamesd.fxtest.contacts.ContactController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ContactApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL location = ContactController.class.getResource("Contacts.fxml");
        FXMLLoader loader = new FXMLLoader(location);
        Parent root = loader.load() ;
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}