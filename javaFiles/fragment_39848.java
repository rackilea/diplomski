while ((r = fileInput.read()) != -1) { // goes through each character in
                                            // file, char by char
        char c = (char) r;
        for (int i = 0; i < 25; i++) {
            for (int y = 0; y < 75 ; y++) { // Adds file values to Array
                GameOfLife.grid[i][y] = c;
            }
        }
    }