package plot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Plot.fxml"));
        Parent root = loader.load();

        stage.setTitle("Plotter");
        stage.setScene(new Scene(root, 1024 , 768));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}