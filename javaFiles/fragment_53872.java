import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Example extends Application {

    final MediaView view = new MediaView();
    Iterator<String> itr ;
    @Override
    public void start(Stage stage) throws Exception {
        final Group root = new Group();
        List<String> list = new ArrayList<String>();
        itr = list.iterator();
        //Plays the first file
        play(itr.next());
        root.getChildren().add(view);
        Scene scene = new Scene(root, 400, 400, Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }
    public void play(String mediaFile){
        Media media = new Media(mediaFile);
        MediaPlayer player = new MediaPlayer(media);
        view.setMediaPlayer(player);
        player.play();
        player.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                player.stop();
                if (itr.hasNext()) {
                    //Plays the subsequent files
                    play(itr.next());
                }
                return;
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}