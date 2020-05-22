public oknoo() {

    initComponents();

    Balonik = new BalloonTip(textfield, new JLabel("Do not devide by 0!"),
            new RoundedBalloonStyle(5,5,Color.WHITE, Color.BLACK), 
            BalloonTip.Orientation.RIGHT_BELOW, 
            BalloonTip.AttachLocation.ALIGNED, 
            15, 
            15, 
            false
    );

    pack();
}