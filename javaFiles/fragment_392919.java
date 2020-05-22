class Player {

    private Scanner inputScanner;
    private PrintStream ps;

    public Player(Scanner inputScanner, PrintStream ps) {
        this.inputScanner = inputScanner;
        this.ps = ps;
    }

    public CardWithColAndRow playRound(int roundNumber) {
        this.displayMessage(String.format("Play round %s", roundNumber + 1));
        this.displayMessage("Type in the card: ");
        int card = inputScanner.nextInt();
        this.displayMessage("Type in the column: ");
        int col = inputScanner.nextInt();
        this.displayMessage("Type in the row: ");
        int row = inputScanner.nextInt();

        return new CardWithColAndRow(card, col, row);
    }

    public void displayMessage(String message) {
        ps.println(message);
    }
}