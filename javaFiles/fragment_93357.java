public class Bucket extends Region { // or extends Pane, Control, some other Parent

  public Bucket() {
    getStyleClass().add("bucket");

    Button button = new Button("Some text");
    getChildren().add(button);
  }
}