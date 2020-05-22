package formatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class PeopleTableController {

    @FXML
    private TableView<Person> table;

    @FXML
    void add(ActionEvent event) {
        table.getItems().add(new Person("Bill", "Jones"));
    }
}