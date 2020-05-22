import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


public class Controller implements Initializable {
    int secondspassed = 0;
    int minutespassed = 0;
    int hourspassed = 0;
    @FXML
    private Label XPTrackerlabel;
    @FXML
    private ProgressBar XPTracker;
    @FXML
    private ComboBox Minelocation;
    @FXML
    private Label clocker;


    Timer timer = new Timer();
    TimerTask ticktime = new TimerTask(){
        public void run(){
            secondspassed++;
            if (secondspassed == 60){ secondspassed = 0; minutespassed++;}
            else if (minutespassed == 60){ minutespassed = 0; hourspassed++;}
            Platform.runLater(() -> clocker.setText(hourspassed + ":" + minutespassed + ":" + secondspassed));
        }
    };

    public void start() {
        timer.scheduleAtFixedRate(ticktime, 1000, 1000);
    }

    public void PressButton(ActionEvent event){
        start();
        System.out.println("Hello World");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Minelocation.getItems().addAll("North", "South", "North-East");
        XPTracker.setProgress(0.5);
        double XP = XPTracker.getProgress() * 100;
        XPTrackerlabel.setText(XP + "%");
        clocker.setText(hourspassed + ":" + minutespassed + ":" + secondspassed);
    }
}