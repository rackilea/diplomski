media.mediaPlayerProperty().bind(Bindings.createObjectBinding(() -> {
    Media m = new Media(songURL.get());
    MediaPlayer player = new MediaPlayer(m);
    player.setAutoPlay(false);
    return player ;
}, songURL));