import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class PrimaryController implements Initializable{
    @FXML ListView<String> lvMain;
    @FXML Button btnAddNewItem;

    ObservableList<String>eventsList = FXCollections.observableArrayList("item1","item2","item3");

    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        lvMain.setItems(eventsList);

        btnAddNewItem.setOnAction((actionEvent) ->
        {
            try
            {
                FXMLLoader addNewItemLoader = new FXMLLoader(getClass().getResource("secondary.fxml"));
                Stage secondStage = new Stage();
                secondStage.setScene(new Scene(addNewItemLoader.load()));
                SecondaryController addNewItemController = addNewItemLoader.getController();                  
                secondStage.showAndWait();
                Optional<String> result = addNewItemController.getNewItem();
                if (result.isPresent()){
                    System.out.println("Your name: " + result.get());
                    eventsList.add(result.get());
                }
            }
            catch (IOException e)
            {
                System.out.println(e.toString());
            }            
        });        
    }
}