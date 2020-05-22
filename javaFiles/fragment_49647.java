private void playWonAnimation(){
    Random rand = new Random();
    SequentialTransition seq = new SequentialTransition();
    for (Node block: tower02List) {
        double xTrans = rand.nextInt(800) + 700;
        double yTrans = rand.nextInt(800) + 700;

        int translateTime = 2500 ;
        int oneRotationTime = 1200 ;

        TranslateTransition translate = new TranslateTransition(Duration.millis(translateTime), block);
        xTrans = (xTrans > 1100) ? xTrans : -xTrans;
        translate.setByX(xTrans);
        translate.setByY(-yTrans);

        RotateTransition rotate = new RotateTransition(Duration.millis(translateTime), block);
        rotate.setByAngle(360 * translateTime / oneRotationTime);

        seq.getChildren().add(new ParallelTransition(translate, rotate));
        seq.getChildren().add(new PauseTransition(Duration.seconds(1.0)));
    }

    seq.play();
}