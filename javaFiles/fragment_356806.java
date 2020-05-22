public void dropDice(IntConsumer valueProcessor){
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> {
        setRandomNum(rand.nextInt(6);
        imageView.setImage(listeFaceDice.get(randomNum-1));
    }));
    timeline.setCycleCount(6);
    timeline.play();
    timeline.setOnFinished(e -> {
        valueProcessor.accept(randomNum);
    });

}