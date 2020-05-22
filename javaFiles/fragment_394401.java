import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.scene.media.*;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class MediaProgressMonitoring extends Application {
    private static final String MEDIA_PATH = "C:\\Users\\Public\\Music\\Sample Music\\Dillon - Thirteen Thirtyfive.mp3";

    public static void main(String[] args) { launch(args); }

    @Override public void start(Stage stage) throws Exception {
        final MediaView   mediaView = createMediaView();
        final MediaPlayer player    = mediaView.getMediaPlayer();
        final ProgressBar progress  = new ProgressBar(0);
        progress.setPrefWidth(800);

        player.currentTimeProperty().addListener((observable) ->
            progress.setProgress(
                player.getCurrentTime().toMillis() / 
                player.getTotalDuration().toMillis()
            )
        );

        StackPane layout = new StackPane();
        layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 20px;");
        layout.getChildren().setAll(
                mediaView,
                progress
        );

        stage.setScene(new Scene(layout));
        stage.show();
    }

    private MediaView createMediaView() throws MalformedURLException {
        String mediaURI = new File(MEDIA_PATH).toURI().toURL().toExternalForm();

        Media media = new Media(mediaURI);
        MediaPlayer player = new MediaPlayer(media);
        MediaView mediaView = new MediaView(player);
        player.play();

        return mediaView;
    }
}