import javafx.application.Application;
import javafx.beans.binding.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.Callable;

/** Displays progress (time elapsed in seconds) of playing a media file. */    
public class TimeElapsedBinding extends Application {
    private static final String MEDIA_PATH = 
        "C:\\Users\\Public\\Music\\Sample Music\\Dillon - Thirteen Thirtyfive.mp3";

    public static void main(String[] args) { launch(args); }

    @Override public void start(Stage stage) throws Exception {
        final MediaView   mediaView    = createMediaView();
        final MediaPlayer player       = mediaView.getMediaPlayer();
        final Label       elapsedLabel = new Label();

        ObjectBinding<TimeElapsed> elapsedBinding =
            createElapsedBindingByBindingsAPI(player);
        StringBinding elapsedStringBinding =
            createStringBindingByBindingsAPI(elapsedBinding);

        elapsedLabel.textProperty().bind(
                elapsedStringBinding
        );

        StackPane layout = new StackPane();
        layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 20px;");
        layout.getChildren().setAll(
                mediaView,
                elapsedLabel
        );

        stage.setScene(new Scene(layout));
        stage.show();
    }

    /* @return an ObjectBinding of immutable TimeElapsed objects for the player */
    private ObjectBinding<TimeElapsed> createElapsedBindingByBindingsAPI(
            final MediaPlayer player
        ) {
        return Bindings.createObjectBinding(
            new Callable<TimeElapsed>() {
                @Override
                public TimeElapsed call() throws Exception {
                    return new TimeElapsed(player.getCurrentTime());
                }
            },
            player.currentTimeProperty()
        );
    }

    /* @return a string binding to an ObjectBinding of immutable TimeElapsed objects */
    private StringBinding createStringBindingByBindingsAPI(
            final ObjectBinding<TimeElapsed> elapsedBinding
        ) {
        return Bindings.createStringBinding(
                new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return String.format(
                                "%.0f",
                                elapsedBinding.getValue().getElapsed()
                        );
                    }
                },
                elapsedBinding
        );
    }

    /* @Return a new MediaView from a predefined MEDIA_PATH string */
    private MediaView createMediaView() throws MalformedURLException {
        String mediaURI = new File(MEDIA_PATH).toURI().toURL().toExternalForm();

        Media media = new Media(mediaURI);
        MediaPlayer player = new MediaPlayer(media);
        MediaView mediaView = new MediaView(player);
        player.play();

        return mediaView;
    }

    /** immutable TimeElapsed class. */
    class TimeElapsed {
        private final double elapsed;

        TimeElapsed(Duration duration) {
            elapsed = duration.toSeconds();
        }

        public double getElapsed() {
            return elapsed;
        }
    }
}