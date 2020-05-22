// Initialize variables row, col, and count = 1

    boolean goDown = true;

    int[][] matrix = new int[row][col];  // declare matrix

    for i = 0 to col:
        if (goDown)
            for j = 0 to row:  // Move in downwards direction
                assign count++ to matrix[j][i] 
                // assign to `[j][i]` because, we have to assign to rows first

            goDown = false;    // Toggle goDown

        else
            for j = row - 1 to 0:  // Move in upwards direction
                assign count++ to matrix[j][i] 

            goDown = true;  // toggle goDown

    }