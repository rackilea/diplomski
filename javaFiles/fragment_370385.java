import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SmoothResize extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Area Chart Sample");
        Group root = new Group();
        Scene scene  = new Scene(root, 250, 250);
        stage.setResizable(false);

        Timer animTimer = new Timer();
        animTimer.scheduleAtFixedRate(new TimerTask() {
            int i=0;

            @Override
            public void run() {
                if (i<100) {
                    stage.setWidth(stage.getWidth()+3);
                    stage.setHeight(stage.getHeight()+3);
                } else {
                    this.cancel();
                }
                i++;
            }

        }, 2000, 25);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}