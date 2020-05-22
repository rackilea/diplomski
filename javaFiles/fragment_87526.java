abstract class Board {
    private final GameSettings gameSettings;

    Board(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }
    public int getTotalColumns() {
        return gameSettings.getCodeLength();
    }
    public int getTotalRows() {
        return gameSettings.getNumOfGuesses();
    }

    //Other abstract methods
}