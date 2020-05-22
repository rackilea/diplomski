public static void enterGame(final Client c) {      
    if(waitingPlayers.size() <= 3) {
        return; // not enough players
    }

    System.out.println("Starting new game");
    Collections.shuffle(waitingPlayers);
    System.out.println("Picking random players");
    // ? to be replaced by the real type of objects inside waitingPlayers
    final List<?> picked = waitingPlayers.subList(0, 3); 
    players.addAll(picked);
    waitingPlayers.removeAll(picked);
}