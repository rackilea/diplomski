import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class MainController implements Initializable {

    @FXML
    public ListView<Student> myListView;
    public ObservableList<Student> studentList;

    public MainController() {
        studentList = FXCollections.observableArrayList();
        studentList.add(new Student("Jimmy", "u0764987", "ef937b3"));
        studentList.add(new Student("John", "u0762809", "543jh32"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (!studentList.isEmpty()) {
            setupListView();
        } else {
            System.out.println("student list is empty");
        }
    }

    private void setupListView() {
        myListView.setItems(studentList);
        myListView.setCellFactory((listView) -> new ListCellController2());
    }
}