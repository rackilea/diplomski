import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class TableResizeRestrictionDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<Person> persons = FXCollections.observableArrayList();
        persons.add(new Person("Harry","John","LS"));
        persons.add(new Person("Mary","King","MS"));
        persons.add(new Person("Don","Bon","CAT"));
        persons.add(new Person("Pink","Wink","IND"));

        CustomTableView<Person> tableView = new CustomTableView<>();
        TableColumn<Person, String> fnCol = new TableColumn<>("First Name");
        fnCol.setCellValueFactory(param -> param.getValue().firstNameProperty());

        TableColumn<Person, String> lnCol = new TableColumn<>("Last Name");
        lnCol.setCellValueFactory(param -> param.getValue().lastNameProperty());

        TableColumn<Person, String> cityCol = new TableColumn<>("City");
        cityCol.setCellValueFactory(param -> param.getValue().cityProperty());

        tableView.getColumns().addAll(fnCol, lnCol, cityCol);
        tableView.setItems(persons);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Scene sc = new Scene(tableView);
        primaryStage.setScene(sc);
        primaryStage.show();

    }

    class Person{
        private StringProperty firstName = new SimpleStringProperty();
        private StringProperty lastName = new SimpleStringProperty();
        private StringProperty city = new SimpleStringProperty();

        public Person(String fn, String ln, String cty){
            setFirstName(fn);
            setLastName(ln);
            setCity(cty);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public StringProperty firstNameProperty() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName.set(firstName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public StringProperty lastNameProperty() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName.set(lastName);
        }

        public String getCity() {
            return city.get();
        }

        public StringProperty cityProperty() {
            return city;
        }

        public void setCity(String city) {
            this.city.set(city);
        }
    }

    class CustomTableView<S> extends TableView<S>{
        private Node headerRow;

        @Override
        protected void layoutChildren() {
            super.layoutChildren();
            if(headerRow ==null){
                headerRow = (Region) lookup("TableHeaderRow");
                headerRow.addEventFilter(MouseEvent.MOUSE_DRAGGED, MouseEvent::consume);
            }
        }
    }
}