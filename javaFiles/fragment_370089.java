import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        ListView<Make> listView = new ListView<>();
        listView.setOrientation(Orientation.HORIZONTAL);

        listView.setMaxHeight(100);

        listView.setCellFactory(lv -> new ListCell<Make>() {
            private Label nameLabel = new Label();
            private Label niceNameLabel = new Label();
            private VBox vbox = new VBox(nameLabel, niceNameLabel);

            {
                vbox.setMaxSize(100, 100);
            }

            @Override
            protected void updateItem(Make make, boolean empty) {
                super.updateItem(make, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    nameLabel.setText(make.getMk_name());
                    niceNameLabel.setText(make.getMk_nicename());
                    setGraphic(vbox);
                }
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldMake, newMake) -> {
            System.out.println(newMake.getMk_name() + " selected");
        });

        for (int i = 1 ; i <= 10 ; i++) {
            Make make = new Make();
            make.setMk_name("Make "+i);
            make.setMk_nicename("Description of make "+i);
            listView.getItems().add(new Make("Make "+i, "Description of make "+i));
        }

        Scene scene = new Scene(new StackPane(listView));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}