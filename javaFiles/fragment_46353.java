final Timeline timeline = new Timeline();
timeline.setCycleCount(Animation.INDEFINITE);
timeline.getKeyFrames().add(
   new KeyFrame(Duration.millis(100)),
   new KeyValue(node.translateXProperty(), 25))
);
timeline.play();