import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        ObservableList<String> list = FXCollections.observableArrayList();

        HBox root = new HBox();

        // add button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {

            list.add("Text");

            System.out.println("Size: " + list.size());

        });

        // remove button
        Button removeButton = new Button("Remove");
        removeButton.setOnAction(e -> {

            if (list.size() > 0) {
                list.remove(0);
            }

            System.out.println("Size: " + list.size());

        });

        root.getChildren().addAll(addButton, removeButton);

        // bind to remove button
        removeButton.disableProperty().bind(Bindings.size(list).isEqualTo(0));

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}