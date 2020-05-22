Timeline timeline = new Timeline(new KeyFrame(
        Duration.millis(500),
        ae -> {
            // do your work here, it runs on the JavaFX application thread
        }));
timeline.setCycleCount(Animation.INDEFINITE);
timeline.play();