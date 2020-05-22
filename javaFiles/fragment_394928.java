import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
public class MenuController implements Initializable {
    @FXML private MenuButton OkMenu;
    @FXML private MenuItem foo1;
    @FXML private MenuItem bar2;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //Define foo1 and bar 2 as errors:
        foo1.getStyleClass().add("error-menu-item");
        bar2.getStyleClass().add("error-menu-item");
    }
}