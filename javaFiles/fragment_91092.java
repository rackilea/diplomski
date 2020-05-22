package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root,400,400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());


            ListView<String> lv = new ListView<>();
            lv.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override 
            public ListCell<String> call(ListView<String> list) {
            return new CellFactory();
              }
            });

            ObservableList<String> items = FXCollections.observableArrayList();
            items.add("asd");
            items.add("fhg");
            items.add("GHI");
            items.add("tead");
            items.add("hoid");

            lv.setItems(items);

            root.setCenter(lv);

            Button btnAdd = new Button("add item");
            btnAdd.setOnMouseClicked(new EventHandler<Event>() {

                @Override
                public void handle(Event event) {
                    items.add(1, "test");
                }
            });

            root.setLeft(btnAdd);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


    static class CellFactory extends ListCell<String> {

      @Override
      public void updateItem(String item, boolean empty) {
          super.updateItem(item, empty);

          if (!empty) {

              super.setTextFill(Color.BLACK); // set TextColor Black

              if (item != null && item.equals("GHI")) {
                  super.setStyle("-fx-font-weight: bold");    //(1)
              }
          }     
          else{
                super.setStyle("-fx-font-weight: normal");    //(2)
          }


          super.setText(item);

      }

    }
}