private long count = 0;

public BasicView(String name) {
    super(name);

    AnimationTimer timer = new AnimationTimer() {
        private long time;

        @Override
        public void handle(long now) {
            if (now - time > 1_000_000_000) {
                count++;
                if (count == 5) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Hi there");
                    alert.showAndWait();
                }
                time = now;
            }

        }
    };

    setCenter(new StackPane(new Label("Hello JavaFX World!")));

    setOnShown(e -> timer.start());
    setOnHidden(e -> timer.stop());
}