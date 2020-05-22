public class SquareButtons extends Application {
@Override
  public void start(final Stage stage) throws Exception {
    /* Assume these are your toolbar elements */
    final Button[] buttons = new Button[]{
            new Button("Short"),
            new Button("Slightly longer"),
            new Button("Very very very long button")
    };

    /* This would, of course, belong in a style sheet - it turns the buttons square */
    for (Button b : buttons)
        b.setStyle("-fx-background-radius: 0");

    /* This will set the pref width/height of all your buttons to the maximum of the pref width/height of the larget one */
    final InvalidationListener listener = new InvalidationListener() {
        public void invalidated(final Observable observable) {
            double size = 0;
            for (Button b : buttons) {
                size = Math.max(size, b.prefWidth(Integer.MAX_VALUE));
                size = Math.max(size, b.prefHeight(Integer.MAX_VALUE));
            }

            for (Button b : buttons) {
                b.setPrefWidth(size);
                b.setPrefHeight(size);
            }
        }
    };

    for (Button b : buttons)
        b.widthProperty().addListener(listener);

    final ToolBar toolbar = new ToolBar();
    toolbar.getItems().addAll(buttons);

    final Scene scene = new Scene(toolbar);
    stage.setScene(scene);
    stage.setWidth(800);
    stage.setHeight(200);
    stage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}