public void makeMove(Point fromPoint, Point toPoint) {
    final Piece[][] prevBoard = board.peek();
    final int width = prevBoard.length;
    Piece[][] boardNode = new Piece[width][];
    for (int i = 0; i < width; i++) {
        final int height = prevBoard[i].length;
        boardNode[i] = new Piece[height];
        for (int j = 0; j < height; j++) {
            Piece p = prevBoard[i][j];
            if (p == null) {
                boardNode[i][j] = null;
            } else {
                boardNode[i][j] = p.clone();
            }
        }
    }