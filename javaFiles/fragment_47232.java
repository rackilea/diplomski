if (check == 1 || check == 7) {
    // add current position to solution
    solution[x][y] = 1;

    // generate an array of all up/down/left/right points that are within bounds
    // - for a random path need to randomise the order of the points
    Point[] points = ... 

    for (Point next : points) {
      if (mazeUtil(next.x, next.y)) {
        // we've found the solution, so just return up the call stack
        return true;
      }
    }

    // this attempt failed, so reset the solution array before returning
    solution[x][y] = 0;

    return false;
  }