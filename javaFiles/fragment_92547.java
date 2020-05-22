//assuming that current spot is at r,c
if (mazePoints[r-1][c] == 'O'){ //up dir
    pointsInMaze.push(new Point(r, c));
    mazePoints[r-1,c] = '';  //empty char marks where you've already been
}
//other directions ommitted here