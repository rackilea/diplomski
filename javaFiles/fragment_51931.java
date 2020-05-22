public static void main(String[] args) {
    // create the config as usual
    final LwjglApplicationConfiguration cfg = createConfig();
    // create your Game
    final game MyGame = new MyGame();

    // create an LwjglFrame with your game and the configuration
    final LwjglFrame frame = new LwjglFrame(game, cfg);

    // add the game as a component listener
    frame.addComponentListener(game);

    // set the frame visible
    frame.setVisible(true);

}