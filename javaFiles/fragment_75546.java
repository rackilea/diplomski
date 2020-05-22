public static void main(String args[]) {
    Window window = new Window(800, 650);
    Game game = new Game();

    window.add(game);
    window.createWindow();
    game.start();
}