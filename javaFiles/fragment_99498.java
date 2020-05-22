package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmailController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fromField;

    @FXML
    private TextField toField;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField subjectField;

    @FXML
    private TextArea messageField;

    @FXML
    private Button deleteButton;

    @FXML
    private Button sendButton;

    @FXML
    void initialize() {


    }
}