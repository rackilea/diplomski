Image image = ...;
BackgroundImage bgImage = new BackgroundImage(
        image,                                                 // image
        BackgroundRepeat.NO_REPEAT,                            // repeatX
        BackgroundRepeat.NO_REPEAT,                            // repeatY
        BackgroundPosition.CENTER,                             // position
        new BackgroundSize(-1, -1, false, false, false, true)  // size
);
anchorPaneBackground.setBackground(new Background(bgImage));