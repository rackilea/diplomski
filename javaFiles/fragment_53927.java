import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SplitMenuButtonTest extends Application {

    @Override
    public void start(Stage primaryStage) {

        IntegerProperty count = new SimpleIntegerProperty();

        SplitMenuButton splitMenuButton = new SplitMenuButton();
        splitMenuButton.setText("Action");
        splitMenuButton.showingProperty().addListener((obs, wasShowing, isNowShowing) -> {
            if (isNowShowing) {
                int c = count.get() + 1;
                count.set(c);
                splitMenuButton.getItems().clear();
                for (int choice = 1; choice <= 3; choice++) {
                    MenuItem mi = new MenuItem("Choice "+choice+" (" + c + ")");
                    splitMenuButton.getItems().add(mi);
                }
            }
        });

        BorderPane root = new BorderPane(null, splitMenuButton, null, null, null);
        primaryStage.setScene(new Scene(root, 350, 150));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}