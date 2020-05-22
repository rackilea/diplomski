import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.concurrent.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ListController {
    @FXML private ListView<User> usersList;

    @FXML void initialize() {
        assert usersList != null : "fx:id=\"usersList\" was not injected: check your FXML file 'list.fxml'.";

        final Task<List<User>> usersListTask = new Task<List<User>>() {
            protected List<User> call() throws SQLException {
                return new DatabaseManager().returnUsers();
            }
        };

        usersListTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                usersList.setItems(
                        FXCollections.observableArrayList(usersListTask.getValue())
                );
            }
        });

        usersListTask.setOnFailed(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                System.out.println("ERROR: " + usersListTask.getException());
            }
        });

        new Thread(usersListTask).start();
    }


    public static class User {
        private final StringProperty name = new SimpleStringProperty();

        public User(String name) {
            this.name.set(name);
        }

        public String getName() {
            return name.get();
        }

        public StringProperty nameProperty() {
            return name;
        }

        public void setName(String name) {
            this.name.set(name);
        }

        @Override
        public String toString() {
            return getName();
        }
    }

    public static class DatabaseManager {
        public List<User> returnUsers() throws SQLException {
            return Arrays.asList(
                new User("Sally"),
                new User("Jenny"),
                new User("Jill"),
                new User("Anne"),
                new User("Carol"),
                new User("Helen")
            );
        }
    }
}