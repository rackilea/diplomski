import java.time.Duration;
import java.util.function.Function;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import org.reactfx.EventStream;
import org.reactfx.EventStreams;

public class AutoSearch extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TextArea area = new TextArea();

        EventStream<KeyEvent> enterPresses = EventStreams.eventsOf(area, KeyEvent.KEY_PRESSED)
                .filter(k -> k.getCode() == KeyCode.ENTER)
                .hook(KeyEvent::consume);

        EventStream<?> searchImpulse = enterPresses.withDefaultEvent(null) // emit an event even before Enter is pressed
                .flatMap(x -> {
                    EventStream<?> edits = EventStreams.changesOf(area.textProperty())
                                                       .successionEnds(Duration.ofSeconds(1));
                    return ((x == null) ? edits : edits.withDefaultEvent(null))
                            .map(Function.identity()); // just to get the proper type of the result
                });

        searchImpulse.subscribe(x -> System.out.println("Search now!"));

        stage.setScene(new Scene(area));
        stage.show();
    }

}