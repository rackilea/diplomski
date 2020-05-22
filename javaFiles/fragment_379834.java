import javafx.scene.Scene;
import javafx.beans.property.DoubleProperty ;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LongAppInitPreloader {
    private ProgressBar bar;

    private Stage stage;

    public LongAppInitPreloader() {
        this.stage = new Stage();
        stage.setScene(createPreloaderScene());
    }

    private Scene createPreloaderScene() {
        bar = new ProgressBar(0);
        BorderPane p = new BorderPane();
        p.setCenter(bar);
        return new Scene(p, 300, 150);
    }

    public void show() {
        stage.show();
    }

    public void hide() {
        stage.hide();
    }

    public DoubleProperty progressProperty() {
        return bar.progressProperty();
    }
}