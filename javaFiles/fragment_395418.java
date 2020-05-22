import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Patrick Ott <Patrick.Ott@professional-webworkx.de>
 */
public class MapController implements Initializable {

    @FXML
    AnchorPane main;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // do some initializing work here
    }

    @FXML
    public void movetest(MouseEvent event) {
        // your code for evaluating if move is possible..
        System.out.println("movetest()");
    }

    @FXML
    public void newcity(ActionEvent event) {
        // your code to create a new City
    }

    @FXML
    public void move(MouseEvent event) {
        Node node = (Node) event.getSource();
        City newCity = new City(node);
        main.getChildren().add(newCity);

    }
}