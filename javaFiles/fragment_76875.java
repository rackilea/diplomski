import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Sedrick
 */
public class JavaFXApplication86 extends Application {
    Timeline timeline;
    AtomicInteger counter;

    @Override
    public void start(Stage primaryStage) {
        Person p1 = new Person("1001", "person1", "11");
        Person p2 = new Person("1002", "person2", "12");
        Person p3 = new Person("1003", "person3", "13");
        Person p4 = new Person("1004", "person4", "14");
        List<Person> personList = new ArrayList();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);        

        counter = new AtomicInteger();
        TableView<Person> tableView = new TableView();
        TableColumn<Person, String> tableId = new TableColumn("ID");
        TableColumn<Person, String> tableName = new TableColumn("Name");
        TableColumn<Person, String> tableAge = new TableColumn("Age");

        ObservableList<Person> personDataTable = FXCollections.observableArrayList();
        tableView.setItems(personDataTable);

        tableId.setCellValueFactory(new PropertyValueFactory("id"));
        tableName.setCellValueFactory(new PropertyValueFactory("name"));
        tableAge.setCellValueFactory(new PropertyValueFactory("age"));

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event ->{
            if(counter.get() >= personList.size())
            {
                timeline.stop();
            }else{
                personDataTable.add(personList.get(counter.getAndIncrement()));
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();




        tableView.getColumns().addAll(tableId, tableName, tableAge);


        StackPane root = new StackPane(tableView);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}