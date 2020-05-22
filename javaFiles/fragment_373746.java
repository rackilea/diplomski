import org.controlsfx.control.CheckComboBox;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage mainStage) throws Exception {


        ObservableList<String> items = FXCollections.observableArrayList();

        items.addAll(new String[] { "All", "Item 1", "Item 2", "Item 3", "Item 4" });

        CheckComboBox<String> controll = new CheckComboBox<String>(items);

        controll.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
            public void onChanged(ListChangeListener.Change<? extends String> c) {

                while (c.next()) {
                    if (c.wasAdded()) {
                        if (c.toString().contains("All")) {

                            // if we call the getCheckModel().clearChecks() this will
                            // cause to "remove" the 'All' too at least inside the model.
                            // So we need to manually clear everything else
                            for (int i = 1; i < items.size(); i++) {
                                controll.getCheckModel().clearCheck(i);
                            }

                        } else {
                            // check if the "All" option is selected and if so remove it
                            if (controll.getCheckModel().isChecked(0)) {
                                controll.getCheckModel().clearCheck(0);
                            }

                        }
                    }
                }
            }
        });

        Scene scene = new Scene(controll);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}