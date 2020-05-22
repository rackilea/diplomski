private Player charCreation() {
    GameWindow gameWindow = new GameWindow();
    gameWindow.openGameWindow();
    gameWindow.printToGameArea("Wake up");
    player.setAge(21);
    player.setName("Kris");
    player.setGender("m");
    return player;
}