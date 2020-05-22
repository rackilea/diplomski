import java.time.LocalDate;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ToDoTable extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<ToDoItem> table = new TableView<>();
        table.getColumns().add(createColumn("Name", ToDoItem::nameProperty));
        TableColumn<ToDoItem, LocalDate> deadlineCol = createColumn("Deadline", ToDoItem::deadlineProperty);
        PseudoClass overdue = PseudoClass.getPseudoClass("overdue");
        deadlineCol.setCellFactory(col -> new TableCell<ToDoItem, LocalDate>() {
            @Override
            public void updateItem(LocalDate deadline, boolean empty) {
                super.updateItem(deadline, empty);
                if (empty) {
                    pseudoClassStateChanged(overdue, false);
                    setText(null);
                } else {
                    pseudoClassStateChanged(overdue, LocalDate.now().isAfter(deadline));
                    setText(deadline.toString());
                }
            }
        });
        table.getColumns().add(deadlineCol);

        for (int i=1; i <= 10; i++) {
            LocalDate deadline = LocalDate.now().plusDays(i - 5);
            ToDoItem item = new ToDoItem("Item "+i, deadline);
            table.getItems().add(item);
        }

        BorderPane root = new BorderPane(table);
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add("overdue.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static <S,T> TableColumn<S,T> createColumn(String title, Function<S, ObservableValue<T>> property) {
        TableColumn<S,T> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        return col ;
    }


    public static class ToDoItem {
        private final StringProperty name = new SimpleStringProperty();
        private final ObjectProperty<LocalDate> deadline = new SimpleObjectProperty<>();

        public ToDoItem(String name, LocalDate deadline) {
            this.name.set(name);
            this.deadline.set(deadline);
        }

        public final StringProperty nameProperty() {
            return this.name;
        }

        public final java.lang.String getName() {
            return this.nameProperty().get();
        }

        public final void setName(final java.lang.String name) {
            this.nameProperty().set(name);
        }

        public final ObjectProperty<LocalDate> deadlineProperty() {
            return this.deadline;
        }

        public final java.time.LocalDate getDeadline() {
            return this.deadlineProperty().get();
        }

        public final void setDeadline(final java.time.LocalDate deadline) {
            this.deadlineProperty().set(deadline);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}