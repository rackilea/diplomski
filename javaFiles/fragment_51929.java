public static void main(String[] args) {
    // create the config as usual
    final LwjglApplicationConfiguration cfg = createConfig();
    // create your ApplicationListener as usual
    final ApplicationListener application = createApplication();

    // create an LwjglFrame with your configuration and the listener
    final LwjglFrame frame = new LwjglFrame(application, cfg);

    // add a component listener for when the frame gets moved
    frame.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentMoved(ComponentEvent e) {
            // somehow pause your game here
            MyGame.getInstance().pauseGame();
        }
    });

    // set the frame visible
    frame.setVisible(true);

}