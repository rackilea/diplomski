import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Counter extends Application {

    private static final String MEDIA_URL = "http://cs.armstrong.edu/liang/common/sample.mp4";
    private TextField text = new TextField();
    int countDown;

    @Override
    public void start(Stage primaryStage) {

        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // create a pane and add a TextField
        BorderPane pane = new BorderPane();
        pane.setCenter(text);
        text.setFont(Font.font("Times", 35));

        // create a new animation
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            if (countDown > 0) {
                countDown--;
                text.setText(Integer.toString(countDown));
            } else {
                mediaPlayer.play();
            }
        }));

        // create and register a handler
        // text.setOnAction(e -> text.setText(text.getText()));
        text.setOnAction(e -> {
            countDown = Integer.parseInt(text.getText());
            animation.setCycleCount(countDown + 1);
            animation.play();
        });

        // create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String args[]) {

        Application.launch(args);

    }

}