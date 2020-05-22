public class TextHighlight extends Application {
  public static void main(String[] args) { Application.launch(args); }
  @Override public void start(Stage stage) {
    final TextArea text = new TextArea("Here is some textz to highlight");
    text.setStyle("-fx-highlight-fill: lightgray; -fx-highlight-text-fill: firebrick; -fx-font-size: 20px;");
    text.setEditable(false);
    text.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent t) { t.consume(); }
    });

    stage.setScene(new Scene(text));
    stage.show();

    Platform.runLater(new Runnable() {
      @Override public void run() { text.selectRange(13, 18); }
    });
  }
}