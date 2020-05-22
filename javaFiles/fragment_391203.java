import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ListViewButtonsSample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple interface
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Create some sample Users
        ObservableList<User> usersList = FXCollections.observableArrayList();
        usersList.addAll(
                new User("Amir"),
                new User("Jasmine"),
                new User("Leonardo")
        );

        // Create the ListView
        ListView<User> listView = new ListView<>();

        // We need to create a new CellFactory so we can display our layout for each individual user
        listView.setCellFactory((Callback<ListView<User>, ListCell<User>>) param -> {
            return new ListCell<User>() {
                @Override
                protected void updateItem(User user, boolean empty) {
                    super.updateItem(user, empty);

                    if (user == null || empty) {
                        setText(null);
                    } else {
                        // Here we can build the layout we want for each ListCell. Let's use a HBox as our root.
                        HBox root = new HBox(10);
                        root.setAlignment(Pos.CENTER_LEFT);
                        root.setPadding(new Insets(5, 10, 5, 10));

                        // Within the root, we'll show the username on the left and our two buttons to the right
                        root.getChildren().add(new Label(user.getUsername()));

                        // I'll add another Region here to expand, pushing the buttons to the right
                        Region region = new Region();
                        HBox.setHgrow(region, Priority.ALWAYS);
                        root.getChildren().add(region);

                        // Now for our buttons
                        Button btnAddFriend = new Button("Add Friend");
                        btnAddFriend.setOnAction(event -> {
                            // Code to add friend
                            System.out.println("Added " + user.getUsername() + " as a friend!");
                        });
                        Button btnRemove = new Button("Remove");
                        btnRemove.setOnAction(event -> {
                            // Code to remove friend
                            System.out.println("Broke up with " + user.getUsername() + "!");
                        });
                        root.getChildren().addAll(btnAddFriend, btnRemove);

                        // Finally, set our cell to display the root HBox
                        setText(null);
                        setGraphic(root);
                    }

                }
            };

        });

        // Set our users to display in the ListView
        listView.setItems(usersList);

        root.getChildren().add(listView);

        // Show the Stage
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}

class User {

    private final StringProperty username = new SimpleStringProperty();

    public User(String username) {
        this.username.set(username);
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }
}