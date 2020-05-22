package sample;

import java.util.concurrent.ThreadLocalRandom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;

public class Controller {

    @FXML
    private ListView<Person> listView;
    private ObservableList<Person> personList = FXCollections.observableArrayList();
    private String[] names = { "John", "Katherine", "Michael", "August", "Peter" };
    private String[] surnames = { "Jones", "Mayer", "Stevens", "Wayne", "Milton" };

    @FXML
    private void initialize() {
        initializeListCells();
        initializeList();
    }

    private void initializeList() {
        for (int i = 0; i < 5; i++) {
            personList.add(generatePerson());
        }
        listView.setItems(personList);
    }

    private void initializeListCells() {
        listView.setCellFactory(param -> {
            ListCell<Person> cell = new ListCell<Person>();
            cell.selectedProperty().addListener((observable, oldValue, newValue) -> handleCellDisplaying(cell));
            cell.itemProperty().addListener((observable, oldValue, newValue) -> handleCellDisplaying(cell));
            return cell;
        });
    }

    private void handleCellDisplaying(ListCell<Person> cell) {
        Person person = cell.getItem();
        if (person != null) {
            if (!cell.isSelected()) {
                cell.setText(person.getBasicView());
            } else {
                cell.setText(person.getExpandedView());
            }
        } else {
            cell.setText("");
        }
    }

    @FXML
    private void addPerson() {
        personList.add(generatePerson());
    }

    @FXML
    private void deletePerson() {
        MultipleSelectionModel<Person> selectionModel = listView.getSelectionModel();
        if (!selectionModel.isEmpty()) {
            int selectedIndex = selectionModel.getSelectedIndex();
            personList.remove(selectedIndex);
        }
    }

    private Person generatePerson() {
        int nameRandom = ThreadLocalRandom.current().nextInt(1, 5);
        int surnameRandom = ThreadLocalRandom.current().nextInt(1, 5);
        return new Person(names[nameRandom], surnames[surnameRandom]);
    }
}