Player newPlayer = new Player();
newPlayer.setPlayerName(playerName);
newPlayer.setPlayerWorth(playerWorth);
newPlayer.setPlayerSpent(playerSpent);

if(!playerAList.contains(newPlayer)){
   playerAList.add(newPlayer);
}