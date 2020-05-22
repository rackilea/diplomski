import java.util.Random;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 /*from   w  w  w.  ja va 2  s. c o  m*/
public class Main extends Application {

    private final TableView<Numbers> table = new TableView<>();
    private final ObservableList<Numbers> data =
            FXCollections.observableArrayList();
    final HBox hb = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setWidth(450);
        stage.setHeight(550);


        TableColumn tcNum1 = new TableColumn("Number One");
        tcNum1.setMinWidth(100);
        tcNum1.setCellValueFactory(
                new PropertyValueFactory<>("num1"));

        TableColumn tcNum2 = new TableColumn("Number Two");
        tcNum2.setMinWidth(100);
        tcNum2.setCellValueFactory(
                new PropertyValueFactory<>("num2"));

        TableColumn tcNum3 = new TableColumn("Number Three");
        tcNum3.setMinWidth(100);
        tcNum3.setCellValueFactory(
                new PropertyValueFactory<>("num3"));

        table.setItems(data);
        table.getColumns().addAll(tcNum1, tcNum2,tcNum3);

        Random random = new Random();


        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            //You focus here!********************
            int num1 = random.nextInt(100);
            int num2 = random.nextInt(100);
            int num3 = num1 + num2;
            data.add(new Numbers(num1, num2, num3));
         });

        hb.getChildren().addAll(addButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static class Numbers {

        private final SimpleIntegerProperty num1;
        private final SimpleIntegerProperty num2;
        private final SimpleIntegerProperty num3;

        private Numbers(int num1, int num2, int num3) {
            this.num1 = new SimpleIntegerProperty(num1);
            this.num2 = new SimpleIntegerProperty(num2);
            this.num3 = new SimpleIntegerProperty(num3);
        }

        public int getNum1() {
            return num1.get();
        }

        public void setNum1(int num1) {
            this.num1.set(num1);
        }

       public int getNum2() {
            return num2.get();
        }

        public void setNum2(int num2) {
            this.num2.set(num2);
        }

        public int getNum3() {
            return num3.get();
        }

        public void setNum3(int num3) {
            this.num3.set(num3);
        }
    }
}