button.setOnAction(e->{
    player.stop();
    player = new MediaPlayer(new Media("http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv"));
    view.setMediaPlayer(player);
    player.play();
});