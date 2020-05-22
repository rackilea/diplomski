import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

public class Controller implements Initializable {

    private final ObservableList<Person> people = FXCollections.observableArrayList();
    //all this was already set in fxml 
    //@FXML private TableView<Person> table;
    //@FXML private TableColumn<Person, SimpleStringProperty> c1;
    //@FXML private TableColumn<Person, SimpleStringProperty> c2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        people.add(new Person("2", "Sam"));
        people.add(new Person("1", "Met"));
    }

    //add a getter to people 
    public ObservableList<Person> getPeople() {
        return people ;
    }
}