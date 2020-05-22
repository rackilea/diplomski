import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable
{

    @FXML
    ProgressBar pbSplash;
    @FXML
    ProgressIndicator piSplash;

    @FXML
    Button button;

    public ProgressBar getPBSplashValue()
    {
        return pbSplash;
    }

    public ProgressIndicator getPISplash()
    {
        return piSplash;
    }

    public Button getButton()
    {
        return button;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}