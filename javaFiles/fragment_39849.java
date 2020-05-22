int y = 0;
    int i = 0;
    while ((r = fileInput.read()) != -1) { // goes through each character in
                                            // file, char by char
        char c = (char) r;
        GameOfLife.grid[i][y] = c;
        y++;
        if (y == 75)
        {
            y = 0;
            ++i;
            if (i == 25)
            {
                break;
            }
        }
    }