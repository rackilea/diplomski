PseudoClass flashHighlight = PseudoClass.getPseudoClass("flash-highlight");
Node flashingNode = ... ;

Timeline flasher = new Timeline(

    new KeyFrame(Duration.seconds(0.5), e -> {
        flashingNode.pseudoClassStateChanged(flashHighlight, true);
    }),

    new KeyFrame(Duration.seconds(1.0), e -> {
        flashingNode.pseudoClassStateChanged(flashHighlight, false);
    })
);
flasher.setCycleCount(Animation.INDEFINITE);