public boolean mazeRunner(x, y) {
    if (!isValidDirection) {
        //TODO: output the attempt
    }
    maze[x][y] = 'x';
    //add (x,y) to current attempt
    //we need to count attempt length 
    if (isSolution(x, y)) {
        //TODO: output the successful attempt
    } else if ((
        (mazeRunner(x - 1, y)) ||
        (mazeRunner(x + 1, y)) ||
        (mazeRunner(x, y - 1)) ||
        (mazeRunner(x, y + 1))
        ) == false) {
        //TODO: Output the current failed attempt
    }
    maze[x][y] = '.';
    //TODO: remove (x, y) from the current attempt
}

public void startMazeRunning(char[][] maze, x, y) {
    this.maze = maze;
}