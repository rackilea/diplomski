import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;



public class TextFileOPG extends Application {

private Stage switchStage;
final double opacity=1;
@Override
public void start(Stage primaryStage) {
try {

        switchStage = primaryStage;

        GridPane root = new GridPane();

        root.setAlignment(Pos.CENTER);

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
        root.add(scenetitle, 3, 2);          


        primaryStage.setTitle("Welcome");
        Scene scene = new Scene(root,350,400);
        primaryStage.setScene(scene);
        primaryStage.show();
        Timeline tick0 = new Timeline();
        tick0.setCycleCount(Timeline.INDEFINITE);
        tick0.getKeyFrames().add(
                new KeyFrame(new Duration(30), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent t) {
                        root.setOpacity(root.getOpacity()-0.01);
                        if(root.getOpacity()<0.01){//30 divided by 0.01 equals 3000 so you take the duration and divide it be the opacity to get your transition time in milliseconds
                            loggedIn();
                            tick0.stop();
                        }
                    }}));
        tick0.play();

} catch(Exception e) {
    e.printStackTrace();
}
}

public void loggedIn() 
{
switchStage.setTitle("Try");

GridPane grid = new GridPane();

grid.setAlignment(Pos.CENTER);

Text thisIsSoCoolText = new Text("Welcome Again");
thisIsSoCoolText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
grid.add(thisIsSoCoolText, 3, 2);

Scene scene = new Scene(grid, 350, 400);
switchStage.setScene(scene);
switchStage.show();
}

  public static void main(String[] args) {
launch(args);
}
}