public void makeMove(Point fromPoint, Point toPoint){
    Piece[][] boardNode = board.peek(); // WARNING!!!
    // Instead, make a copy of the previous board state
    // so  you don't change all board states when you want to change one.
    boardNode[fromPoint.y][fromPoint.x].setPoint(toPoint);
    boardNode[toPoint.y][toPoint.x] = boardNode[fromPoint.y][fromPoint.x];
    boardNode[fromPoint.y][fromPoint.x] = null;
    board.push(boardNode); // WARNING!!!
}