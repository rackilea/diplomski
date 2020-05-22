import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    @Override public void start(Stage stage) {

        stage.setTitle("Main Stage");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();

        Stage subStage = new Stage();
        subStage.setTitle("Sub Stage");
        subStage.setWidth(250);
        subStage.setHeight(250);
        subStage.initOwner(stage);
        subStage.initModality(Modality.WINDOW_MODAL);
        subStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}