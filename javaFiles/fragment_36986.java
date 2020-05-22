import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TableColumnDropTargetExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Person> table = new TableView<>();
        table.getColumns().add(column("First Name", Person::firstNameProperty));
        table.getColumns().add(column("Last Name", Person::lastNameProperty));
        table.getColumns().add(column("Email", Person::emailProperty));

        ObjectProperty<TableColumn<?,?>> dropTargetColumn = new SimpleObjectProperty<>();

        table.getColumns().forEach(col -> configureDropTargetColumn(col, dropTargetColumn));

        table.getItems().addAll(createData());

        Label label = new Label("Drag me");
        label.getStyleClass().add("drag-source");

        label.setOnDragDetected(e -> {
            Dragboard db = label.startDragAndDrop(TransferMode.COPY_OR_MOVE);
            ClipboardContent cc = new ClipboardContent();
            cc.putString(label.getText());
            db.setContent(cc);
        });
        label.setOnDragDone(e -> dropTargetColumn.set(null));

        BorderPane root = new BorderPane(table);
        root.setTop(label);
        BorderPane.setAlignment(label, Pos.CENTER);

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private <S,T> void configureDropTargetColumn(TableColumn<S,T> column, ObjectProperty<TableColumn<?,?>> dropTarget) {

        Callback<TableColumn<S,T>, TableCell<S,T>> currentCellFactory = column.getCellFactory() ;

        column.setCellFactory(tc -> {
            TableCell<S,T> cell = currentCellFactory.call(tc);
            dropTarget.addListener((obs, oldColumn, newColumn) -> 
                    cell.pseudoClassStateChanged(PseudoClass.getPseudoClass("drop-target"), newColumn==column));
            cell.setOnDragEntered(e -> dropTarget.set(column));
            cell.setOnDragExited(e -> dropTarget.set(null));
            return cell ;
        });
    }

    private static <S,T> TableColumn<S,T> column(String text, Function<S, ObservableValue<T>> property) {
        TableColumn<S,T> col = new TableColumn<>(text);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        return col ;
    }

    private List<Person> createData() {
        return Arrays.asList(
                new Person("Jacob", "Smith", "jacob.smith@example.com"),
                new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                new Person("Ethan", "Williams", "ethan.williams@example.com"),
                new Person("Emma", "Jones", "emma.jones@example.com"),
                new Person("Michael", "Brown", "michael.brown@example.com")     
        );
    }

    public static class Person {
        private final StringProperty firstName = new SimpleStringProperty();
        private final StringProperty lastName = new SimpleStringProperty();
        private final StringProperty email = new SimpleStringProperty();


        public Person(String firstName, String lastName, String email) {
            setFirstName(firstName);
            setLastName(lastName);
            setEmail(email);
        }


        public final StringProperty firstNameProperty() {
            return this.firstName;
        }



        public final String getFirstName() {
            return this.firstNameProperty().get();
        }



        public final void setFirstName(final String firstName) {
            this.firstNameProperty().set(firstName);
        }



        public final StringProperty lastNameProperty() {
            return this.lastName;
        }



        public final String getLastName() {
            return this.lastNameProperty().get();
        }



        public final void setLastName(final String lastName) {
            this.lastNameProperty().set(lastName);
        }



        public final StringProperty emailProperty() {
            return this.email;
        }



        public final String getEmail() {
            return this.emailProperty().get();
        }



        public final void setEmail(final String email) {
            this.emailProperty().set(email);
        }



    }

    public static void main(String[] args) {
        launch(args);
    }
}