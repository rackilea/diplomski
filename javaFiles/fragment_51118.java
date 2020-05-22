public boolean isSolvable(int[] puzzle)
{
    int parity = 0;
    int gridWidth = (int) Math.sqrt(puzzle.length);
    int row = 0; // the current row we are on
    int blankRow = 0; // the row with the blank tile

    for (int i = 0; i < puzzle.length; i++)
    {
        if (i % gridWidth == 0) { // advance to next row
            row++;
        }
        if (puzzle[i] == 0) { // the blank tile
            blankRow = row; // save the row on which encountered
            continue;
        }
        for (int j = i + 1; j < puzzle.length; j++)
        {
            if (puzzle[i] > puzzle[j] && puzzle[j] != 0)
            {
                parity++;
            }
        }
    }

    if (gridWidth % 2 == 0) { // even grid
        if (blankRow % 2 == 0) { // blank on odd row; counting from bottom
            return parity % 2 == 0;
        } else { // blank on even row; counting from bottom
            return parity % 2 != 0;
        }
    } else { // odd grid
        return parity % 2 == 0;
    }
}