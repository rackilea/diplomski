import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.PixelWriter;
import javafx.scene.canvas.*;

public class Render extends Application {

    private PixelWriter pw;

    public static void render(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Placeholder Title");
        Canvas canvas = new Canvas(1280, 720);
        Group root = new Group(canvas);
        Scene scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        pw = canvas.getGraphicsContext2D().getPixelWriter();
        testRender(); // we can't call this before everything has been initialized anyway
        stage.show();
    }
    // this doesn't need to be static
    private void testRender() {
        int c = -1;
        for (int x = 0; x < 1280; x++) {
            for (int y = 0; y < 720; y++, c--) {
                pw.setArgb(x, y, c);
            }
        }
    }
}