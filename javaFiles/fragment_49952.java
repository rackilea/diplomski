import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

// delays event key press handling so that some events can be intercepted
// and routed to a bar code a reader and others can be processed by the app.
public class EventRefire extends Application {
  public static void main(String[] args) { launch(args); }
  @Override public void start(final Stage stage) throws Exception {
    // create the scene.
    final VBox layout = new VBox();
    final Scene scene = new Scene(layout);

    // create a queue to hold delayed events which have not yet been processed.
    final List<KeyEvent> unprocessedEventQueue = new ArrayList();
    // create a queue to hold delayed events which have already been processed.
    final List<KeyEvent> processedEventQueue = new ArrayList();

    // create some controls for the app.
    final TextField splitterField1 = new TextField(); splitterField1.setId("f1");
    final TextField splitterField2 = new TextField(); splitterField2.setId("f2");
    final Label forBarCode   = new Label();
    final Label forTextField = new Label();

    // filter key events on the textfield and don't process them straight away.
    stage.addEventFilter(KeyEvent.ANY, new EventHandler<KeyEvent>() {
      @Override public void handle(KeyEvent event) {
        if (event.getTarget() instanceof Node) {
          if (!processedEventQueue.contains(event)) {
            unprocessedEventQueue.add((KeyEvent) event.clone());
            event.consume();
          } else {
            processedEventQueue.remove(event);
          }  
        }  
      }
    });

    // set up a timeline to simulate handling delayed event processing from 
    // the barcode scanner.
    Timeline timeline = new Timeline(
      new KeyFrame(
        Duration.seconds(1), 
        new EventHandler() {
          @Override public void handle(Event timeEvent) {
            // process the unprocessed events, routing them to the barcode reader
            // or scheduling the for refiring as approriate.
            final Iterator<KeyEvent> uei = unprocessedEventQueue.iterator();
            final List<KeyEvent> refireEvents = new ArrayList();
            while (uei.hasNext()) {
              KeyEvent event = uei.next();
              String keychar = event.getCharacter();
              if ("barcode".contains(keychar)) {
                forBarCode.setText(forBarCode.getText() + keychar);
              } else {
                forTextField.setText(forTextField.getText() + keychar);
                refireEvents.add(event);
              }
            }

            // all events have now been processed - clear the unprocessed event queue.
            unprocessedEventQueue.clear();

            // refire all of the events scheduled to refire.
            final Iterator<KeyEvent> rei = refireEvents.iterator();
            while (rei.hasNext()) {
              KeyEvent event = rei.next();
              processedEventQueue.add(event);
              if (event.getTarget() instanceof Node) {
                ((Node) event.getTarget()).fireEvent(event);
              }
            }
          }
        }
      )
    );
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();

    // layout the scene.
    final GridPane grid = new GridPane();
    grid.addRow(0, new Label("Input Field 1:"), splitterField1);
    grid.addRow(1, new Label("Input Field 2:"), splitterField2);
    grid.addRow(2, new Label("For App:"),       forTextField);
    grid.addRow(3, new Label("For BarCode:"),   forBarCode);
    grid.setStyle("-fx-padding: 10; -fx-vgap: 10; -fx-hgap: 10; -fx-background-color: cornsilk;");

    Label instructions = new Label("Type letters - key events which generate the lowercase letters b, a, r, c, o, d, e will be routed to the barcode input processor, other key events will be routed back to the app and processed normally.");
    instructions.setWrapText(true);
    layout.getChildren().addAll(grid, instructions);
    layout.setStyle("-fx-padding: 10; -fx-vgap: 10; -fx-background-color: cornsilk;");
    layout.setPrefWidth(300);
    stage.setScene(scene);
    stage.show();
  }
}