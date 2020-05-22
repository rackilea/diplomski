import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    // The Label which holds the username value
    private Label lblUsername = new Label();

    // Grab a reference to the GlobalData singleton
    private GlobalData globalData = GlobalData.getInstance();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Create the initial sample User
        globalData.setSelectedUser(new User("User #1"));

        // Simple interface
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // HBox to hold the username display
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);

        // Add the username labels to the HBox
        hBox.getChildren().addAll(
                new Label("Username:"),
                lblUsername
        );

        // Bind the Label to display the current selected user's username
        lblUsername.textProperty().bind(globalData.getSelectedUser().usernameProperty());

        // Here we use a listener on the the selectedUser property. When it changes, we
        // call the rebindUser() method to update the UI
        globalData.selectedUserProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                rebindUser(newValue);
            }
        });

        // Add a button that just changes the selectedUser
        Button button = new Button("Change User");

        // Set the action for the button to change users
        button.setOnAction(this::changeUser);

        // Add the HBox and button to the root layout
        root.getChildren().addAll(hBox, button);

        // Show the Stage
        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void changeUser(ActionEvent event) {

        // Create a new user with a random # at the end
        Random rnd = new Random();
        int num = rnd.nextInt(50 + 2);

        globalData.setSelectedUser(new User("User #" + num));
    }

    // This method accepts a new User object and updates all the displayed bindings
    private void rebindUser(User newUser) {
        lblUsername.textProperty().unbind();
        lblUsername.textProperty().bind(newUser.usernameProperty());
    }
}