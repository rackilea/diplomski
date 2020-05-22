import de.professional_webworkx.crm.business.IPersonService;
import de.professional_webworkx.crm.business.PersonService;
import de.professional_webworkx.crm.domain.Person;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLController implements Initializable {

    private IPersonService service;

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Person p = new Person("Demo", "User", "demo@example.com");
        service.saveOrUpdate(p);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // get an instance of PersonService
        service = new PersonService();

    }    
}