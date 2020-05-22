try {
    URL url = AppUtils.consiguePath(12);
    Player player = new Player(url.openStream());
    player.play();
} catch (JavaLayerException | IOException e) {
    e.printStackTrace();
}