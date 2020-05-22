public static void main(String[] args){
    Game game = new Game();
    game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
    game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
    game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

    JFrame frame = new JFrame("Tile RPG");
    frame.setSize(WIDTH *SCALE, HEIGHT * SCALE);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.add(game);
    frame.setVisible(true);

    // Add this line
    game.init();        

    game.start();
    }
}