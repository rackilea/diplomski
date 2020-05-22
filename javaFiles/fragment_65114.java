ProgressBar progress = new ProgressBar();
    IntegerProperty seconds = new SimpleIntegerProperty();
    progress.progressProperty().bind(seconds.divide(60.0));
    Timeline timeline = new Timeline(
        new KeyFrame(Duration.ZERO, new KeyValue(seconds, 0)),
        new KeyFrame(Duration.minutes(1), e-> {
            // do anything you need here on completion...
            System.out.println("Minute over");
        }, new KeyValue(seconds, 60))   
    );
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();