import javafx.application.Application;
 import javafx.beans.value.ChangeListener;
 import javafx.beans.value.ObservableValue;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.Scene;
 import javafx.scene.layout.AnchorPane;
 import javafx.stage.Stage;


 public class Main extends Application {
 @Override
 public void start(Stage primaryStage) {
    try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("pane.fxml"));
        AnchorPane rootLayout = loader.load();

        Scene scene = new Scene(rootLayout);
        //rootLayout.prefWidthProperty().bind(scene.widthProperty()); not needed
        //rootLayout.prefHeightProperty().bind(scene.heightProperty());in these scenario
        primaryStage.setScene(scene);
        primaryStage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {

    launch(args);
}
}