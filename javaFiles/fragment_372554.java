import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewExperiments extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("ListView Experiment 1");

        Label label = new Label("Hello World!");

        ListView<Person> listView = new ListView();
        listView.setCellFactory(lv -> new ListCell<Person>()
        {
            @Override
            public void updateItem(Person item, boolean empty)
            {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                    setOnMouseClicked(null);
                }
                else {
                    setText(item.getFirstName() + " " + item.getLastName());
                    setOnMouseClicked(event -> {
                        if (event.getClickCount() == 2) {
                            label.setText(item.getFirstName() + item.getLastName());
                        }
                    });
                }

            }
        });

        listView.getItems().add(new Person("a", "b"));
        listView.getItems().add(new Person("c", "d"));
        listView.getItems().add(new Person("e", "f"));

        VBox vBox = new VBox(listView, label);

        Scene scene = new Scene(vBox, 300, 120);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}