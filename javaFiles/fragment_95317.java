import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ListDisplay extends Application {
    @Override
    public void start(Stage stage) {
        ListView<TaskItem> listView = new ListView<>(
                FXCollections.observableArrayList(
                        new TaskItem("Todo Tasks", null, true, true),
                        new TaskItem("Senility", "The Autumn Years", false, false),
                        new TaskItem("Death", "But I didn't eat the salmon mousse", false, false),
                        new TaskItem("Done Tasks", null, true, true),
                        new TaskItem("Birth", "The Miracle of Life", true, false),
                        new TaskItem("School", "Growth and Learning", true, false),
                        new TaskItem("Middle Age", "Stagnation", true, false),
                        new TaskItem("Live Organ Transplants", "The Machine that goes 'Ping'", true, false)
                )
        );

        listView.setCellFactory(param -> new ListCell<TaskItem>() {
            @Override
            protected void updateItem(TaskItem item, boolean empty) {
                super.updateItem(item, empty);

                if (!empty && item != null) {
                    if (item.isHeader()) {
                        setText(item.getName());
                        setStyle("-fx-font-weight: bold;");
                    } else {
                        setText(item.getName() + " - " + item.getDescription());
                        setStyle(null);
                    }
                } else {
                    setText(null);
                }
            }
        });

        listView.setPrefHeight(200);

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isHeader()) {
                System.out.println("Selected: " + newValue.getName());
            }
        });

        stage.setTitle("Monty Python's Meaning of Life");
        stage.setScene(new Scene(listView));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class TaskItem {
        private final String name;
        private final String description;
        private final SimpleBooleanProperty completed;
        private final boolean header;

        public TaskItem(String name, String description, boolean completed, boolean header) {
            this.name = name;
            this.description = description;
            this.completed = new SimpleBooleanProperty(completed);
            this.header = header;
        }

        public boolean isHeader() {
            return header;
        }

        public boolean isCompleted() {
            return completed.get();
        }

        public SimpleBooleanProperty completedProperty() {
            return completed;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }
    }
}