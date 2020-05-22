import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

    public class Clock extends Application {

         @Override public void start(Stage stage) {

            DateFormat df = new SimpleDateFormat("EEE,MMM d yyyy - h:mm:ss a");
            Date date = new Date();
            String stringDate = df.format(date);

            Text text = new Text(10, 60, stringDate);
            text.setFont(Font.font ("Digital Dream Fat", 30f));
            text.setFill(Color.RED);

            HBox hbox = new HBox();


            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0),
        new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
              Date update = new Date();
            String stringNewDate = df.format(update);
                    text.setText(stringNewDate);
            }
        }

        ), new KeyFrame(Duration.seconds(1)));
              timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play(); // timeline.stop()

            Scene scene = new Scene(new Group(text));
            scene.setFill(Color.BLACK);

            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setWidth(710);
            stage.setHeight(80);
            stage.show(); 
        }

        public static void main(String[] args) {
            launch(args);
        }
    }