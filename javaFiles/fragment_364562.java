import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        StackPane root = new StackPane();

        Scene scene = new Scene(root, 450, 250);

        Button btn = new Button();
        btn.setText("Run");

        final ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Phase 1", "Phase 2", "Phase 3", "Phase 4", "Phase 5");

        GridPane grid = new GridPane();

        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Select Phase: "), 0, 0);
        grid.add(comboBox, 1, 0);
        grid.add(new Label("Select Data: "), 0, 1);
        grid.add(btn, 0, 2);


        root.getChildren().add(grid);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) { launch(args);}
}