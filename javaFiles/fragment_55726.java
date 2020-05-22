import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {

    // Here, we define our FXML elements. This allows us to access those elements directly from our Controller
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblEmailAddress;

    // This is the User object that holds the data we want to display
    private User user;

    public MainController(User user) {
        this.user = user;
    }

    /**
     * The initialize() method is called when the FXML document is loaded. This is where we will populate our Scene
     * with the data from the User object passed to the controller's constructor. Since we already created our
     * constructor from the Main class, we have a valid User object to work with
     */
    @FXML
    private void initialize() {

        // There are two basic ways we can setup our Scene to display the User data. This demonstrates the proper Binding
        // method of doing so.

        // Bind the value of each Label to show the corresponding data from the User object
        lblUsername.textProperty().bind(user.usernameProperty());
        lblEmailAddress.textProperty().bind(user.emailAddressProperty());

        // The other method would be to simply set the text for each label. We will comment this out, however, as
        // using the above binding is preferred.
//        lblUsername.setText(user.getUsername());
//        lblEmailAddress.setText(user.getEmailAddress());

    }
}