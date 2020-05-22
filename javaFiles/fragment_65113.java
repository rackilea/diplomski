ProgressBar progress = new ProgressBar();
    Timeline timeline = new Timeline(
        new KeyFrame(Duration.ZERO, new KeyValue(progress.progressProperty(), 0)),
        new KeyFrame(Duration.minutes(1), e-> {
            // do anything you need here on completion...
            System.out.println("Minute over");
        }, new KeyValue(progress.progressProperty(), 1))    
    );
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();