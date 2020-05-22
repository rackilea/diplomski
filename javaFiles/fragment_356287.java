import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 *
 * @author sedri
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    JFXListView listview;
    @FXML ListView<String> lvAddNew;
    @FXML Button btnAddNew;    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for(int i = 1; i < 100; i++)
        {
           JFXCheckBox tempJFXCheckBox = new JFXCheckBox("item " + i);
           tempJFXCheckBox.selectedProperty().addListener((obs, oldValue, newValue)->{
               System.out.println(newValue);
               if(newValue)
               {
                   listview.getItems().remove(tempJFXCheckBox);
                   lvAddNew.getItems().add(tempJFXCheckBox.getText());
               }
           });

           listview.getItems().add(tempJFXCheckBox);           
        }     
    }   

    @FXML private void handleBtnAddNew(ActionEvent event)
    {
        //Remove selected item
        String tempList = lvAddNew.getSelectionModel().getSelectedItem();
        lvAddNew.getItems().remove(tempList);
        listview.getItems().add(new JFXCheckBox(tempList));        
    }
}