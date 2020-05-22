import java.util.Random;

import javafx.application.Platform;

public class DataProducer extends Thread {

    private final UI ui ;

    public DataProducer(UI ui) {
        this.ui = ui ;
        setDaemon(true);
    }

    @Override
    public void run()  {
        Random rng = new Random();
        try {
            while (true) {
                MyDataClass data = new MyDataClass(rng.nextInt(100));
                Platform.runLater(() -> ui.registerData(data));
                Thread.sleep(rng.nextInt(1000) + 250);
            } 
        } catch (InterruptedException e) {
            // Ignore and allow thread to exit
        }
    }
}