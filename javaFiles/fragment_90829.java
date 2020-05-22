button.setOnAction((event) -> { // better to use ActionEvent to listen to button activation
    event.consume();
    var random = new Random();
    Color currentColor = (Color) rectangle.getFill();
    Color targetColor = Color.color(random.nextFloat(), random.nextFloat(), random.nextFloat());

    var timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(rectangle.fillProperty(), currentColor)),
            new KeyFrame(Duration.millis(500),
                    evt -> {
                        var number = random.nextInt(10) + 1;
                        var word = "";
                        for (var i = 0; i < number; i++) {
                            word += (char) ('a' + random.nextInt(26));
                        }
                        text.setText(word);
                    },
                    new KeyValue(effect.widthProperty(), 10),
                    new KeyValue(effect.heightProperty(), 10)
            ), new KeyFrame(Duration.millis(1000),
                    new KeyValue(effect.widthProperty(), 0),
                    new KeyValue(effect.heightProperty(), 0),
                    new KeyValue(rectangle.fillProperty(), targetColor)
            )
    );
    timeline.play();
});