if (grid[x][y].minePresent == false)
        {
            grid[x][y].setCurrent("*");
            grid[x][y].minePresent = true;
            count++;
        }