import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewValues extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple Interface
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        // Simple TableView
        TableView<Person> personTableView = new TableView<>();
        TableColumn<Person, String> colName = new TableColumn<>("Name");
        TableColumn<Person, String> colCar = new TableColumn<>("Car");

        // Setup the CellValueFactories
        colName.setCellValueFactory(tf -> tf.getValue().nameProperty());
        colCar.setCellValueFactory(tf -> tf.getValue().getCar().modelProperty());

        personTableView.getColumns().addAll(colName, colCar);

        root.getChildren().add(personTableView);

        // Sample Data
        personTableView.getItems().addAll(
                new Person("Jack", new Car("Accord")),
                new Person("John", new Car("Mustang")),
                new Person("Sally", new Car("Yugo"))
        );

        // Show the stage
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Sample");
        primaryStage.show();
    }
}

class Person {

    private final StringProperty name = new SimpleStringProperty();
    private final ObjectProperty<Car> car = new SimpleObjectProperty<>();

    public Person(String name, Car car) {
        this.name.set(name);
        this.car.set(car);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public Car getCar() {
        return car.get();
    }

    public void setCar(Car car) {
        this.car.set(car);
    }

    public ObjectProperty<Car> carProperty() {
        return car;
    }
}

class Car {
    private final StringProperty model = new SimpleStringProperty();

    public Car(String model) {
        this.model.set(model);
    }

    public String getModel() {
        return model.get();
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public StringProperty modelProperty() {
        return model;
    }
}