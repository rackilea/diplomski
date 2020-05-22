static void slowScrollToBottom(ScrollPane scrollPane) {
    Animation animation = new Timeline(
        new KeyFrame(Duration.seconds(2),
            new KeyValue(scrollPane.vvalueProperty(), 1)));
    animation.play();
}