public void start(){
    Game newGame = new Game();
    newGame.running = true;
    t1 = new Thread(newGame);
    t1.start();
}