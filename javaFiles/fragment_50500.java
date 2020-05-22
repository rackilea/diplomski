for (int i = 0; i < chessboard.length; i++) {
    for (int j = 0; j < chessboard[0].length; j++) {
        // You could encapsulate these lines in a isValidSquareForQueenMove(x, y) method.
        boolean isSquareValid = false;
        isSquareValid = isSquareValid || x == queen.x;
        isSquareValid = isSquareValid || y == queen.y;
        isSquareValid = isSquareValid || Math.abs(queen.x - x) == Math.abs(queen.y - y);
        isSquareValid = isSquareValid && x != queen.x && y != queen.y;

        // Do stuff here.
    }
}