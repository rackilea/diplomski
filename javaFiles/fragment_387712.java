public void cardOne(Scanner scanner, PlayerType player, GameType game) {
    TextUserInterface UI = TextUserInterface.getUI();
    Set<GreenPlayerCard> playerCards = player.getPlayerCards();
    discardCard = UI.getCardChoice(playerCards,"Choose a card to discard: ");

    String optionChoice = null;
    System.out.println("\t1- to Confirm Discard Card, enter 1");
    System.out.println("\t2- Do nothing, enter 2");
    System.out.print("Choice: ");
    input: for(;;) {
        optionChoice = scanner.nextLine();
        switch (optionChoice) {
        case "1":
            game.discardCard(discardCard, player);
            break input;
        case "2": break input;
        default: System.out.println("\tPlease enter your choice:");
        }
    }
}