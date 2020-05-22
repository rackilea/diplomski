import com.sun.javafx.scene.control.skin.TableHeaderRow;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TestApp extends Application {

    private TableView<Person> table = new TableView<Person>();
    private final ObservableList<Person> data = FXCollections.observableArrayList(
            new Person("Jacob", "Smith", "jacob.smith@example.com", "845-548-600"),
            new Person("Isabella", "Johnson", "isabella.johnson@example.com", "455-777-645"),
            new Person("Ethan", "Williams", "ethan.williams@example.com", "888-504-254"),
            new Person("Emma", "Jones", "emma.jones@example.com", "123-548-350"),
            new Person("Michael", "Brown", "michael.brown@example.com", "650-120-600"));

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(550);
        stage.setHeight(500);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));

        TableColumn phoneCol = new TableColumn("Phone");
        phoneCol.setMinWidth(100);
        phoneCol.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, phoneCol);

        table.skinProperty().addListener((obs, oldSkin, newSkin) -> {
            final TableHeaderRow header = (TableHeaderRow) table.lookup("TableHeaderRow");
            header.reorderingProperty().addListener((o, oldVal, newVal) -> {
                ObservableList columns = table.getColumns();

                // If the first columns is not in the first index change it
                if (columns.indexOf(firstNameCol) != 0) {
                    columns.remove(firstNameCol);
                    columns.add(0, firstNameCol);
                }
                // Use the same logic for the last column
                if (columns.indexOf(phoneCol) != columns.size() - 1) {
                    columns.remove(phoneCol);
                    columns.add(columns.size(), phoneCol);
                }
            });
        });

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static class Person {

        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty phone;

        private Person(String fName, String lName, String email, String phone) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
            this.phone = new SimpleStringProperty(phone);
        }

        public String getPhone() {
            return phone.get();
        }

        public String getFirstName() {
            return firstName.get();
        }

        public String getLastName() {
            return lastName.get();
        }

        public String getEmail() {
            return email.get();
        }

    }
}