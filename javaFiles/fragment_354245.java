public class Board {

    // Creates the board
    public static Node[][] board = new Node[11][11];

    public Board() {
        // Create an empty node and place it in  every other location
        // like a checkered board.
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j< board[i].length; j+=2) {
                if(i%2 == 0) {
                    // Even row start at 0
                    board[i][j] = new Node(null);
                }
                else if(j+1 < board[i].length) {
                    // Odd row and less than length, start at 1
                    board[i][j+1] = new Node(false);
                }
            }
        }
    }
}