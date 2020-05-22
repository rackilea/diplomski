import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditorController {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnSave;

    private Data data;

    // Constructor to accept the object to be edited
    public EditorController(Data data) {
        this.data = data;
    }

    @FXML
    private void initialize() {

        // Bind the data to the textfields
        txtName.textProperty().bindBidirectional(data.nameProperty());
        txtEmail.textProperty().bindBidirectional(data.emailProperty());

        btnSave.setOnAction(e -> handleSave());

    }

    private void handleSave() {
        // Just close the stage
        ((Stage) txtEmail.getScene().getWindow()).close();
    }
}