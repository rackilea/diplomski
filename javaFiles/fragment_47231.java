if (check == 9) {
    out.println("Found the goal!");
    return true;         
  }

  if (check == 1 || check == 7) {
    // add current position to solution
    solution[x][y] = 1;

    // generate random move within bounds
    int nextX = ...
    int nextY = ...

    if (mazeUtil(nextX, nextY)) {
      // we've found the solution, so just return up the call stack
      return true;
    }

    // this attempt failed, so reset the solution array before returning
    solution[x][y] = 0;

    return false;
  }

  // shouldn't ever get here...
  throw new IllegalStateException("moveCheck returned unexpected value: " + check);