@Override
public void start(Stage primaryStage) throws IOException {
    Label display = new Label();
    Button playPause = new Button();

    IntegerProperty property = new SimpleIntegerProperty(0);

    // this invokes the logic once per second
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), evt -> {
        property.set(property.get()+1); // replace this with your method call
    }));
    timeline.setCycleCount(Animation.INDEFINITE);

    display.textProperty().bind(property.asString());
    playPause.textProperty().bind(
            Bindings.when(timeline.statusProperty().isEqualTo(Status.RUNNING))
            .then("pause").otherwise("play"));

    playPause.setOnAction(evt -> {
        // toggle running/paused timeline
        if (timeline.getStatus() == Status.RUNNING) {
            timeline.pause();
        } else {
            timeline.play();
        }
    });

    VBox vbox = new VBox(playPause, display);

    Scene scene = new Scene(vbox);
    primaryStage.setScene(scene);
    primaryStage.show();
}