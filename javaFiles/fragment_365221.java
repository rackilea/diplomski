public Window(int width, int title, String title, Game game) {
    super(title);
    HandlerClass handler = new HandlerClass();

    setPreferredSize(new Dimension(width,height));
    setMaximumSize(new Dimension(width,height));
    setMinimumSize(new Dimension(width,height));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);

    setVisible(true);
    add(game, BorderLayout.CENTER);
    game.addMouseListener(handler);     
    game.start();
}