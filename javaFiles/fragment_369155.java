/**
 * Creates a m * n-grid where each entry is either 0 or 1,
 * each row contains the same amount of 1's and 0's and where no
 * three consecutive cells in horizontal or vertical direction
 * contain the same entry.
 */
public int[][] makeGrid(int n, int m) {
    // since we want the same number of 1's and 0's per row and
    // per column, both n and m must be even numbers
    if (n % 2 == 1) {
        throw new IllegalArgumentException("n must be an even number");
    }
    if (m % 2 == 1) {
        throw new IllegalArgumentException("m must be an even number");
    }

    int[][] grid = new int[n][m];

    // initialize grid: cells that have not yet been assigned a
    // value shall be marked with -1
    for (int y = 0; y < m; y++) {
        for (int x = 0; x < n; x++) {
            grid[x][y] = -1;
        }
    }

    Random random = new Random();

    int[][] colCounts = new int[n][2];
    int[][] rowCounts = new int[m][2];

    // we're filling the grid from top to bottom and from left to
    // right. Instead of using two ints (say, x and y), we
    // awkwardly use an int-array with two entries. The only
    // reason for that is hideous construction is so that we can
    // implement 'backtrack' as a separate method.
    int[] xy = new int[2];
    for (xy[1] = 0; xy[1] < m; xy[1]++) {
        for (xy[0] = 0; xy[0] < n; xy[0]++) {
            // if the grid cell we're currently looking at is
            // empty, we set it to either 1 or 0 at random, unless
            // we've already exhausted the maximum number of 1's
            // or 0's per row or column, in which case we have to
            // use whatever is the opposite value.
            if (grid[xy[0]][xy[1]] == -1) {
                int cell;
                if (rowCounts[xy[1]][0] == n / 2) {
                    if (colCounts[xy[0]][1] == n / 2) {
                        backtrack(xy, n, m);
                        continue;
                    } else {
                        cell = 1;
                    }
                } else if (rowCounts[xy[1]][1] == n / 2) {
                    if (colCounts[xy[0]][0] == n / 2) {
                        backtrack(xy, n, m);
                        continue;
                    } else {
                        cell = 0;
                    }
                } else {
                    cell = random.nextInt(2);
                }

                // if the chosen value resulted in a constraint
                // violation, we cannot leave it. By decrementing
                // xy[0], we make sure that the inner for-loop above
                // will come back here again in the next
                // step. When it does, it will go into the 'else'
                // case below because grid[xy[0]][xy[1]] is now no longer
                // -1
                if (!setGrid(grid, xy[0], xy[1], cell, n, m, colCounts, rowCounts)) {
                    xy[0]--;
                }
            } else {
                // the grid value at (xy[0],xy[1]) was set before, but the
                // value then chosen apparently lead to a
                // constraint violation. Whatever value that was,
                // let's try the other value instead.
                if (!setGrid(grid, xy[0], xy[1], 1 - grid[xy[0]][xy[1]], n, m, colCounts, rowCounts)) {
                    // the other value did not work either, so we
                    // have to backtrack further to find a remedy.
                    // Undo the grid value and move back to
                    // previous grid position.
                    colCounts[xy[0]][grid[xy[0]][xy[1]]]--;
                    rowCounts[xy[1]][grid[xy[0]][xy[1]]]--;
                    grid[xy[0]][xy[1]] = -1;
                    backtrack(xy, n, m);
                }
            }
        }
    }

    return grid;
}

protected boolean setGrid(int[][] grid, int x, int y, int cell, int n, int m, int[][] colCounts, int[][] rowCounts) {
    // if a grid value was already set before at (x,y) the
    // colCounts and rowCounts were changed accordingly, too. We
    // have to undo that change first.
    if (grid[x][y] != -1) {
        colCounts[x][grid[x][y]]--;
        rowCounts[y][grid[x][y]]--;
    }

    grid[x][y] = cell;

    // now, we can update the colCounts and rowCounts according to
    // the value we just set
    colCounts[x][cell]++;
    rowCounts[y][cell]++;

    // check whether no more than two cells in a row have the same
    // value
    if (x-2 >= 0) {
        if (grid[x-2][y] == cell &&
            grid[x-1][y] == cell) {
            return false;
        }
    }

    // check whether no more than two cells in a column have the
    // same value
    if (y-2 >= 0) {
        if (grid[x][y-2] == cell &&
            grid[x][y-1] == cell) {
            return false;
        }
    }

    return true;
}

private void backtrack(int[] xy, int n, int m) {
    // move one column to the left, if possible, otherwise move
    // one row up
    if (xy[0] == 0) {
        if (xy[1] == 0) {
            // we cannot backtrack any further
            throw new IllegalArgumentException("No solution possible for n=" + n + ", m=" + m);
        }
        // backtrack to the last column in the
        // previous row
        xy[0] = n - 2;
        xy[1]--;
    } else {
        // backtrack to the previous column
        xy[0] -= 2;
    }
}