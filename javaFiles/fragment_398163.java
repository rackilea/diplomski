import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;


public class MainController {

    // Define the FXML controls
    @FXML
    private TableView<Data> tblDataView;
    @FXML
    private TableColumn<Data, String> colName;
    @FXML
    private TableColumn<Data, String> colEmail;
    @FXML
    private Button btnDoThings;

    @FXML
    private void initialize() {

        // Create sample Data objects for the TableView
        ObservableList<Data> dataList = FXCollections.observableArrayList();
        dataList.add(new Data("Bob", "bob@email.com"));
        dataList.add(new Data("Harley", "harley@coolspot.com"));
        dataList.add(new Data("Jane", "jane@email.com"));
        dataList.add(new Data("Moby", "mobyboy@toocool.com"));

        // Setup the TableView columns to display the correct data
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Bind the list of sample data to the TableView
        tblDataView.setItems(dataList);

        // Set the action for the button
        btnDoThings.setOnAction(event -> doThings());

    }

    private void doThings() {
        // If no item has been selected from the table, do nothing
        if (tblDataView.getSelectionModel().getSelectedItem() == null) return;

        // Load the new window
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("EditorLayout.fxml"));

            // Create the new controller and pass the currently selected data item to it
            EditorController controller = new EditorController(tblDataView.getSelectionModel().getSelectedItem());

            // Set the controller to the loader
            loader.setController(controller);

            Stage editorStage = new Stage();
            editorStage.setTitle("Edit Item");

            // Centers the editor window over the current window
            editorStage.initOwner(tblDataView.getScene().getWindow());

            // Ensures the new window needs to be closed before the current window can be used again
            editorStage.initModality(Modality.APPLICATION_MODAL);

            editorStage.setScene(new Scene(loader.load()));
            editorStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}