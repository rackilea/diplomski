{
    PongServerThread game = new PongServerThread();
    while(true)
    {
        games.add(game);
        System.out.println("Game Added");
        game.start();

        game = new PongServerThread();
    }
}