public void addComponentToPane(Container pane) {
    …
    pane.add(cards, BorderLayout.PAGE_END);
}
…
private static void createAndShowGUI() {
    JFrame frame = new JFrame("Login");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Move frame to lower right corner of screen
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
    Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
    int x = (int) rect.getMaxX() - frame.getWidth();
    int y = (int) rect.getMaxY() - frame.getHeight();
    frame.setLocation(x, y);

    CardLayoutDemo demo = new CardLayoutDemo();
    demo.addComponentToPane(frame.getContentPane());

    frame.pack();
    frame.setVisible(true);
}