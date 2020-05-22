import java.util.concurrent.BlockingQueue;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class UI {

    private final TextArea textArea ;
    private final Parent view ;
    private long total ;
    private long count ;
    private final DoubleProperty average = new SimpleDoubleProperty(0);


    public UI(BlockingQueue<MyDataClass> queue) {
        textArea = new TextArea();

        Label aveLabel = new Label();
        aveLabel.textProperty().bind(average.asString("Average: %.3f"));

        view = new BorderPane(textArea, null, null, aveLabel, null);

        // thread to take items from the queue and process them:

        Thread queueConsumer = new Thread(() -> {
            while (true) {
                try {
                    MyDataClass data = queue.take();
                    Platform.runLater(() -> registerData(data));
                } catch (InterruptedException exc) {
                    // ignore and let thread exit
                }
            }
        });
        queueConsumer.setDaemon(true);
        queueConsumer.start();
    }

    public void registerData(MyDataClass data) {
        textArea.appendText(String.format("Data: %d (received %.3f milliseconds after generation)%n", 
                data.getValue(), data.age()/1_000_000.0)); 
        count++;
        total+=data.getValue();
        average.set(1.0*total / count);
    }

    public Parent getView() {
        return view ;
    }
}