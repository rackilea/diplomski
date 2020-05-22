// int x, y;  // position to look around 
for (int xDiff = -1; xDiff <= 1; xDiff++) {
    for (int yDiff = -1; yDiff <= 1; yDiff++) {
        if (xDiff == 0 && yDiff == 0) continue;
        if (board[y+yDiff][x+xDiff]) { 
            ar += 1;
        }
    }
}