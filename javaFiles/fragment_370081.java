import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class FirstViewController implements Initializable {

    @FXML private MenuItem openTabMI, closeMI;
    @FXML private TabPane tabPane;
    private Tab myDynamicTab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        openTabMI.setOnAction((event)->{
            createTabDynamically();
        });

        closeMI.setOnAction((event)->{Platform.exit();});
    }

    private void createTabDynamically() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("secondView.fxml"));
        loader.setController(new SecondViewController());
        try {
            Parent parent = loader.load();
            myDynamicTab = new Tab("A Dynamic Tab");
            myDynamicTab.setClosable(true);
            myDynamicTab.setContent(parent);
            tabPane.getTabs().add(myDynamicTab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}