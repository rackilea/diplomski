if (playerList.contains(name)) {
    System.out.println("Please enter a different name!");
    i--;
} else {
    playerList.add(new Player(name, STARTING_MONEY, 0));
}