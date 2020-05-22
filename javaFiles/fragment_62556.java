public boolean isValidDirection(x, y) {
    return ((x < maze.length) &&
            (x >= 0) &&
            (y < maze[x].length) &&
            (y >= 0) &&
            (maxe[x][y] == '.'));
}

public boolean isSolution(x, y) {
    return isValidDirection(x, y) && (((x % maze.length) - 1 == 0) || ((y % maze[x].length) - 1 == 0));
}