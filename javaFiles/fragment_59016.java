Timeline flasher = new Timeline(

    new KeyFrame(Duration.seconds(0.5), e -> {
        // use "flash" color
    }),

    new KeyFrame(Duration.seconds(1.0), e -> {
        // revert to regular color
    })
);