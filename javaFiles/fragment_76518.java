import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class ListApplication extends Application {
    @Override public void start(Stage stage) throws Exception{
        Parent layout = FXMLLoader.load(getClass().getResource("list.fxml"));
        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}