import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TwoTableTest extends Application {

private ChangeListener<Number> table1SelectionListener ;
private ChangeListener<Number> table2SelectionListener ;

@Override
public void start(Stage primaryStage) {
    TableView<Person> table1 = createTableView() ;
    TableView<Person> table2 = createTableView() ;

    table1.getSelectionModel().select(0);
    table2.getSelectionModel().select(0);

    table1SelectionListener = (obs, oldIndex, newIndex) -> {
        int table1SelectedIndex = table1.getSelectionModel().getSelectedIndex() ;
        int table2SelectedIndex = table2.getSelectionModel().getSelectedIndex() ;
        if (table1SelectedIndex != table2SelectedIndex) {
            Platform.runLater(() -> table2.getSelectionModel().select(table1SelectedIndex));
        }
    };

    table2SelectionListener = (obs, oldIndex, newIndex) -> {
        int table1SelectedIndex = table1.getSelectionModel().getSelectedIndex() ;
        int table2SelectedIndex = table2.getSelectionModel().getSelectedIndex() ;
        if (table1SelectedIndex != table2SelectedIndex) {
            Platform.runLater(() -> table1.getSelectionModel().select(table2SelectedIndex));
        }
    };
    table1.getSelectionModel().selectedIndexProperty().addListener(table1SelectionListener);
    table2.getSelectionModel().selectedIndexProperty().addListener(table2SelectionListener);

    HBox root = new HBox(5, table1, table2);
    Scene scene = new Scene(root, 800, 600);
    primaryStage.setScene(scene);
    primaryStage.show();
}

private TableView<Person> createTableView() {
    TableView<Person> table = new TableView<>();
    TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
    firstNameCol.setCellValueFactory(data -> data.getValue().firstNameProperty());

    TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
    lastNameCol.setCellValueFactory(data -> data.getValue().lastNameProperty());

    TableColumn<Person, String> emailCol = new TableColumn<>("Email");
    emailCol.setCellValueFactory(data -> data.getValue().emailProperty());

    table.getColumns().addAll(firstNameCol, lastNameCol);

    table.getItems().addAll(
            new Person("Jacob", "Smith", "jacob.smith@example.com"),
            new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
            new Person("Ethan", "Williams", "ethan.williams@example.com"),
            new Person("Emma", "Jones", "emma.jones@example.com"),
            new Person("Michael", "Brown", "michael.brown@example.com")        
    );

    return table ;
}

public static void main(String[] args) {
    launch(args);
}

public static class Person {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty email ;


    Person(String firstName, String lastName, String email) {
        this.firstName = new SimpleStringProperty(this, "firstName",
                firstName);
        this.lastName = new SimpleStringProperty(this, "lastName", lastName);
        this.email = new SimpleStringProperty(this, "email", email);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email ;
    }

    @Override
    public String toString() {
        return firstName.get() + " " + lastName.get();
    }

}
}