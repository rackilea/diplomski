for (int i = 0; i < players.length; i++) {
    Player playerTemp = new Player("Player" + i, gameBall);
    playerTemp.start();
    players[i] = playerTemp;
    System.out.println(players[i].getName1() +" started");
}