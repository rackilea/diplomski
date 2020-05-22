private void resetBoard() {
    board = new Pieces[8][8];

    // board[0] is a reference to MainLine so if we change move
    // into or out of board[0] MainLine will be affected and 
    // we won't be able to start with a fresh board by calling boardReset()
    // board[0] = MainLine;

    // Initialize the first row to a fresh array every time we call
    // reset.
    board[0] = new Pieces[] { 
        Pieces.ROOK, Pieces.KNIGHT, Pieces.BISHOP, Pieces.QUEEN, 
        Pieces.KING, Pieces.BISHOP, Pieces.KNIGHT, Pieces.ROOK
    };

    // This makes the last line and
    // the first line point to the same array
    // You need to create a new array that is a deep copy
    // of the array.
    // board[board.length - 1] = MainLine; 

    // Create new array by copying the original array
    board[board.length - 1] = Arrays.copyOf(board[0], board[0].length);

    // Similarly
    //board[1] = BishopLine;
    Arrays.fill(board[1], Pieces.PAWN);
    board[board.length - 2] = Arrays.copyOf(board[1], board[1].length);

    // You don't need member variables MainLine and BishopLine
    // and you can remove them if you want.
}