import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

// displays equal width buttons which fill a layout region's width.
// http://stackoverflow.com/questions/12830402/javafx-2-buttons-size-fill-width-and-are-each-same-width
public class HorizontallyTiledButtons extends Application {
  public static void main(String[] args) { launch(args); }
  @Override public void start(Stage stage) {
    final Button addButton    = new Button("Add");
    final Button removeButton = new Button("Remove");
    final Button extraButton  = new Button("The wizard of Frobozz is watching");

    final ButtonBar buttonBar = new ButtonBar(5, addButton, removeButton);

    addButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
        buttonBar.addButton(extraButton);
      }
    });

    removeButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
        buttonBar.removeButton(extraButton);
      }
    });

    VBox layout = new VBox(10);
    layout.getChildren().addAll(buttonBar);
    layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");

    stage.setScene(new Scene(layout));
    stage.setWidth(800);
    stage.show();
  }

  class ButtonBar extends HBox {
    ButtonBar(double spacing, Button... buttons) {
      super(spacing);
      getChildren().addAll(buttons);
      for (Button b: buttons) {
        HBox.setHgrow(b, Priority.ALWAYS);
        b.setMaxWidth(Double.MAX_VALUE);
      }
    }

    public void addButton(Button button) {
      HBox.setHgrow(button, Priority.ALWAYS);
      button.setMaxWidth(Double.MAX_VALUE);
      ObservableList<Node> buttons = getChildren();
      if (!buttons.contains(button)) {
        buttons.add(button);
      }
    }

    public void removeButton(Button button) {
      getChildren().remove(button);
    }

    @Override protected void layoutChildren() {
      double minPrefWidth = calculatePrefChildWidth();
      for (Node n: getChildren()) {
        if (n instanceof Button) {
          ((Button) n).setMinWidth(minPrefWidth);
        }
      }
      super.layoutChildren();
    }

    private double calculatePrefChildWidth() {
      double minPrefWidth = 0;
      for (Node n: getChildren()) {
        minPrefWidth = Math.max(minPrefWidth, n.prefWidth(-1));
      }
      return minPrefWidth;
    }
  }
}