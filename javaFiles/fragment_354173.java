import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainNoFXML extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        for (int i = 0; i < 1000; i++) {
            Label label = new Label("Label Number"+i);
            vBox.getChildren().add(label);
        }

        Scene scene = new Scene(vBox);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}