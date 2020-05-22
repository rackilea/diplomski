import java.io.File;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import processing.core.PApplet;
import processing.core.PImage;
import processing.javafx.PSurfaceFX;

public class UsingProcessing extends PApplet {

    private static final String VIDEO_FILE_NAME = "teste.mp4";
    private static final String DIRECTORY = "/home/vladwoguer/Downloads/";
    Stage stage;

    ZonedDateTime now = ZonedDateTime.now();
    LocalDateTime startOfDay = now.toLocalDate().atStartOfDay();
    javafx.util.Duration duration = Duration.ZERO;

    public static void main(String[] args) {

        PApplet.main("UsingProcessing");
    }

    public void settings() {
        size(300, 300, FX2D);
    }

    public void setup() {

        try {

            Field field = PSurfaceFX.class.getDeclaredField("stage");
            field.setAccessible(true);
            stage = (Stage) field.get(surface);

            File f = new File(DIRECTORY, VIDEO_FILE_NAME);

            Media media = new Media(f.toURI().toURL().toString());
            javafx.scene.media.MediaPlayer player = new javafx.scene.media.MediaPlayer(media);
            MediaView viewer = new MediaView(player);

            DoubleProperty width = viewer.fitWidthProperty();
            DoubleProperty height = viewer.fitHeightProperty();
            width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
            height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
            viewer.setPreserveRatio(true);

            StackPane root = new StackPane();
            root.getChildren().add(viewer);
            Node processingCanvas = stage.getScene().getRoot().getChildrenUnmodifiable().get(0);

            root.getChildren().add(processingCanvas);
            Scene scenes = new Scene(root, 300, 300, Color.TRANSPARENT);
            stage.setScene(scenes);
            stage.setTitle("OBSV.CamFeed.6°07'08.3\"S 12°23'51.5\"E");
            stage.setFullScreen(false);
            stage.show();
            player.setStartTime(duration);
            player.setCycleCount(MediaPlayer.INDEFINITE);
            player.play();

        }

        catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void draw() {
        PImage img;
        img = loadImage(DIRECTORY + "background_1.png");
        background(img);
        rect(50, 50, 150, 150); // Just for testing, if anything can show up in
    }
}