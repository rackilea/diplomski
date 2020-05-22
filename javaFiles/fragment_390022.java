final Random rand = new Random();

int random = rand.nextInt(100-5)+5;
final Circle circle = new Circle(0, 10, random);
circle.setFill(Color.RED);
root.getChildren().add(circle);

Timeline timeline = new Timeline(
    new KeyFrame(
      Duration.seconds(2),
      event -> circle.setRadius(rand.nextInt(100-5)+5),
      new KeyValue(circle.translateXProperty(), 600)
 ));
timeline.setCycleCount(Animation.INDEFINITE);
timeline.setAutoReverse(false);
timeline.play();