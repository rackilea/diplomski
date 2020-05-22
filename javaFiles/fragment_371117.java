public boolean findTour(int x, int y, int c) {
    solutionBoard[x][y] = c;
    if (c == size*size) {
        return true;
    }
    for (Point p : MOVES) {
        Point dst =  new Point(x + p.x, y + p.y);
        if (canMove(dst) && findTour(dst.x, dst.y, c + 1)) {
            return true;
        }       
    }
    solutionBoard[x][y] = -1;
    return false;
}