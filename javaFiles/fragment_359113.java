import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.paint.*;
import javafx.stage.Stage;

public class CanvasEffects extends Application {

    @Override
    public void start(Stage stage) {
        final Image image = new Image(IMAGE_LOC);

        final int NUM_IMGS = 5;
        final double W = image.getWidth();
        final double H = image.getHeight();

        final Canvas canvas = new Canvas(W * NUM_IMGS, H);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GOLD);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setGlobalBlendMode(BlendMode.SCREEN);

        for (int i = 0 ; i < NUM_IMGS; i++) {
            final double opacity = 1 - ((double) i) / NUM_IMGS;
            System.out.println(opacity);
            gc.setGlobalAlpha(opacity);
            gc.setEffect(new BoxBlur(i * 2, i * 2, 3));

            gc.drawImage(image, i * W, 0);
        }

        stage.setScene(new Scene(new Group(canvas)));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    // icon license: Linkware (Backlink to http://uiconstock.com required) commercial usage not allowed.
    private static final String IMAGE_LOC = "http://icons.iconarchive.com/icons/uiconstock/flat-halloween/128/Halloween-Bat-icon.png";
}