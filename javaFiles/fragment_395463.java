public Screen() {
    DrawScreen screen = new DrawScreen();
    mDrawScreensMato = screen.getMato();
    addKeyListener(this);
    add(screen);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // This is a useless call as DrawScreen
    // does not provide appropriate sizing hints to the layout manager
    pack();
    setSize(400, 400);
    // This needs to be called AFTER the size of window has been determined,
    // as it uses the size of the window to determine it's location
    setLocationRelativeTo(null);
    setVisible(true);
}