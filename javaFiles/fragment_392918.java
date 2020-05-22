class Game {

    private static final int MAX_NUMBER_OF_PLAYERS = 5;
    private static final int NUMBER_OF_ROUNDS_IN_A_GAME = 3;

    private final List<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    public void run() {
        int roundsCounter = 0;

        while (roundsCounter < NUMBER_OF_ROUNDS_IN_A_GAME) {
            for (Player currentPlayer : this.players) {

                CardWithColAndRow cardWithColAndRow = currentPlayer.playRound(roundsCounter);
                placeCardOnBoard(cardWithColAndRow.getCard(), cardWithColAndRow.getRow(), cardWithColAndRow.getCol());
            }

            roundsCounter++;
        }

        end();
    }

    public void placeCardOnBoard(int cardAtindex, int row, int col) {

        // logic for placing card

    }

    public boolean registerPlayer(Player player) {
        if (this.players.size() == MAX_NUMBER_OF_PLAYERS) {
            return false;
        }

        this.players.add(player);

        return true;
    }

    public void end() {
        this.players.stream().forEach(player -> player.displayMessage("Game ended"));
    }

}