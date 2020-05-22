for (int i = 0; i < rounds; i++){
   int playerThrow = player.makeThrow();
   int compThrow = gameObject.makeCompThrow();
   gameObject.announceWinner (compThrow, playerThrow );
}
System.out.print (gameObject.bigWinner(winner, rounds));