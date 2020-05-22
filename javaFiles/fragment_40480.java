PauseTransition pt = new PauseTransition(Duration.millis(500));
pt.setOnFinished(ae -> {
    // do your work here, it runs on the JavaFX application thread
});
SequentialTransition seq = new SequentialTransition(pt);
seq.setCycleCount(Animation.INDEFINITE);
seq.play();