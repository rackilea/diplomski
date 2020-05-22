import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginServiceApp extends Application {
    private LoginService loginService = new LoginService();

    @Override
    public void start(Stage stage) throws IOException {
        Pane loginPane = createLoginPane();
        loginService.setOnSucceeded(event ->
                stage.getScene().setRoot(createAppPane(stage))
        );

        stage.setScene(new Scene(new StackPane(loginPane)));
        stage.show();
    }

    private Pane createLoginPane() {
        GridPane credentialsGrid = new GridPane();
        credentialsGrid.setHgap(10);
        credentialsGrid.setVgap(10);
        TextField usernameField = new TextField("frobozz");
        PasswordField passwordField = new PasswordField();
        credentialsGrid.addRow(0, new Label("Username"), usernameField);
        credentialsGrid.addRow(1, new Label("Password"), passwordField);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> {
            loginService.setUsername(usernameField.getText());
            loginService.setPassword(passwordField.getText());
            loginService.restart();
        });
        loginButton.disableProperty().bind(loginService.runningProperty());

        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.visibleProperty().bind(loginService.runningProperty());
        progressIndicator.setPrefSize(20, 20);

        HBox loginControl = new HBox(10, loginButton, progressIndicator);
        VBox loginPane = new VBox(10, credentialsGrid, loginControl);
        loginPane.setPadding(new Insets(10));

        return loginPane;
    }

    private Pane createAppPane(Stage stage) {
        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(event -> stage.getScene().setRoot(createLoginPane()));
        HBox appPane = new HBox(logoutButton);
        appPane.setPadding(new Insets(10));

        return appPane;
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class LoginService extends Service<Void> {
        private StringProperty username = new SimpleStringProperty(this, "username");
        public final void setUsername(String value) { username.set(value); }
        public final String getUsername() { return username.get(); }
        public final StringProperty usernameProperty() { return username; }

        private StringProperty password = new SimpleStringProperty(this, "password");
        public final void setPassword(String value) { password.set(value); }
        public final String getPassword() { return password.get(); }
        public final StringProperty passwordProperty() { return password; }

        @Override
        protected Task<Void> createTask() {
            final String _username = getUsername();
            final String _password = getPassword();
            return new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    // Simulate a long call to a login service,
                    // using the username and password we saved when the task was created.
                    // If login fails, an exception can be raised to report it and the
                    // caller starting the service can monitor setOnException to handle it.
                    // Or the Task could return a result value instead of void and the caller
                    // could monitor the value property of the task in addition to the exception handler.
                    Thread.sleep(1_000);
                    return null;
                }
            };
        }
    }
}