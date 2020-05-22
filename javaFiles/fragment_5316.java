class Move {
    int row, column;

    public Move(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

public void undoMove(int row, int column, int[][] board) {
    board[row][column] = 0;
}

// Later on, in your game loop method
ArrayList<Move> moves = new ArrayList<Move>();

// Adding moves
// In your program, you'll get the row and column from what
// the user types in or clicks on. 
int row = 1, column = 7;
moves.add( new Move(row, column) );

row = 6, column = 8;
moves.add( new Move(row, column) );

// Undo'ing moves
Move moveToUndo = moves.get( moves.size() - 1 );
undoMove(moveToUndo.row, moveToUndo.column, sudokuGrid);
moves.remove( moves.size() - 1 );