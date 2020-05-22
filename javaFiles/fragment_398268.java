import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.scenicview.ScenicView;

public class DisabilityAssistance extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        TextArea area = new TextArea("Text Area");
        area.setDisable(true);
        TextField field = new TextField("Text Field");
        field.setDisable(true);

        Scene scene = new Scene(new VBox(10, area, field));
        stage.setScene(scene);
        stage.show();

        scene.getStylesheets().add(getClass().getResource(
                "disability.css"
        ).toURI().toURL().toExternalForm());

        ScenicView.show(stage.getScene());
    }

    public static void main(String[] args) {
        launch(args);
    }
}