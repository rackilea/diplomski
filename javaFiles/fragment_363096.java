public class TestBoardSpace {
    public static void main(String[] args) {
        Board board = new Board();
        for (int y = 0; y < Board.ROWS; y++) {
            for (int x = 0; x < Board.COLS; x++) {
                System.out.printf("%8s ", board.getBoardSpace(x, y).getColor());
            }
            System.out.println();
        }
    }
}