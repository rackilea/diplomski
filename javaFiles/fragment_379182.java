import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        CheckBox askFirst = new CheckBox("confirm before allowing close");
        Tab tab = new Tab("Close Me", askFirst);
        tab.setOnCloseRequest((Event t) -> {
            if (askFirst.isSelected()) {
                Alert areYouSureAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> result = areYouSureAlert.showAndWait();
                if (result.isEmpty() || result.get() != ButtonType.YES) {
                    t.consume();
                }
            }
        });
        TabPane tp = new TabPane(tab);
        stage.setScene(new Scene(tp));
        stage.show();
        Platform.setImplicitExit(true);
    }

}