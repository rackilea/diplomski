import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ListViewScrollExample extends Application {

   private ListView<String> listView;

   @Override
   public void start(Stage stage) throws Exception {
       listView = new ListView<>();
       listView.getItems().add("Some quite long string to demonstrate the problem");

       listView.setCellFactory(lv -> {
           ListCell<String> cell = new ListCell<String>() {

               private Label label = new Label();
               {
                   label.setWrapText(true);
                   label.maxWidthProperty().bind(Bindings.createDoubleBinding(
                           () -> getWidth() - getPadding().getLeft() - getPadding().getRight() - 1, 
                           widthProperty(), paddingProperty()));
                   setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
               }

               @Override
               protected void updateItem(String item, boolean empty) {
                   super.updateItem(item, empty);
                   if (empty) {
                       setGraphic(null);
                   } else {
                       label.setText(item);
                       setGraphic(label);
                   }
               }
           };
           return cell ;
       });

       Scene scene = new Scene(listView);
       stage.setScene(scene);
       stage.show();
    }


    public static void main(String[] args){
        Application.launch(args);
    }

}