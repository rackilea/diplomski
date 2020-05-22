for (int i = 1; i < numStepsRequired; i++) {
    int currX = x + i * dx;
    int currY = y + i * dy;
    if (board[currY][currX] != null) {
        return false;
    }
}