public Game() {
    model = new Model();
    model.add(new Tile(Tile.randomLetter(), Color.WHITE));
    model.add(new Tile(Tile.randomLetter(), Color.RED));
    model.add(new Tile(Tile.randomLetter(), Color.GREEN));
    model.add(new Tile(Tile.randomLetter(), Color.YELLOW));

    JFrame frame = new JFrame();
    frame.getContentPane().setLayout(new GridLayout(4, 1));
    frame.setSize(500, 800);
    frame.setVisible(true);

    for (Tile tile : model.getTiles()) {
        frame.add(tile);
    }

    model.addModelListener(new ModelListener() {
        @Override
        public void tileWasRemoved(Tile tile) {
            frame.remove(tile);
            frame.revalidate();
            frame.repaint();
        }
    });
    frame.getContentPane().addKeyListener(this);
    frame.getContentPane().setFocusable(true);
    frame.getContentPane().requestFocusInWindow();
}