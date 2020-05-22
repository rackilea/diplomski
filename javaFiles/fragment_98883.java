package com.example;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginController {

    @FXML private GridPane root;
    @FXML private TextField userField;
    @FXML private PasswordField passField;
    @FXML private Button loginBtn;

    private LoginService service;

    @FXML
    private void initialize() {
        service = new LoginService();
        service.usernameProperty().bind(userField.textProperty());
        service.passwordProperty().bind(passField.textProperty());

        // Don't let user interact with UI while trying to login
        BooleanBinding notReadyBinding = service.stateProperty().isNotEqualTo(Worker.State.READY);
        userField.disableProperty().bind(notReadyBinding);
        passField.disableProperty().bind(notReadyBinding);
        loginBtn.disableProperty().bind(notReadyBinding);

        root.cursorProperty().bind(
                Bindings.when(service.runningProperty())
                        .then(Cursor.WAIT)
                        .otherwise(Cursor.DEFAULT)
        );

        service.setOnSucceeded(event -> serviceSucceeded());
        service.setOnFailed(event -> serviceFailed());
    }

    private void serviceSucceeded() {
        if (service.getValue()) {
            /*
             * Normally you'd change the UI here to show whatever the user needed to
             * sign in to see. However, to allow experimentation with this example
             * project we simply show an Alert and call reset() on the LoginService.
             */
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "You've successfully logged in.");
            service.reset();
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Your username or password is incorrect.");
            service.reset();
        }
    }

    private void serviceFailed() {
        showAlert(Alert.AlertType.ERROR, "Login Failed", "Something when wrong while trying to log in.");
        service.getException().printStackTrace();
        service.reset();
    }

    private void showAlert(Alert.AlertType type, String header, String content) {
        Alert alert = new Alert(type);
        alert.initOwner(root.getScene().getWindow());
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        event.consume();

        // isBlank() is a String method added in Java 11
        boolean blankUsername = userField.textProperty().getValueSafe().isBlank();
        boolean blankPassword = passField.textProperty().getValueSafe().isBlank();

        if (blankUsername || blankPassword) {
            showAlert(Alert.AlertType.ERROR, null, "Both username and password must be specified.");
        } else {
            service.start();
        }
    }

}