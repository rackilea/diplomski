public class Board {

    private String[] grid;
    private int[][] winCombinations;

    public Board() {
            this.grid = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8" };
            this.winCombinations = new int[][] { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7, },
                            { 2, 5, 8 }, { 0, 4, 8 }, { 2, 4, 6 } };
    }

    /**
     * Cloning constructor to make a deep copy of the original source
     * @param sourceBoard Object to be deep copied to a new instance
     */
    public Board(Board sourceBoard) {
            this();
            System.arraycopy(sourceBoard.grid, 0, this.grid, 0, sourceBoard.grid.length);

            for (int i = 0; i < winCombinations.length; i++) {
                    int[] line = winCombinations[i];
                    System.arraycopy(sourceBoard.winCombinations[i], 0, line, 0, line.length);
            }
    }