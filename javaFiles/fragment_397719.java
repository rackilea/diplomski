this.setLayout(new GridLayout(ROWS, COLS, 1, 1));
this.setBorder(new LineBorder(Color.RED));


    for (int row = 0; row < ROWS; row++)
        for (int col = 0; col < COLS; col++)
            this.add(new Location(row, col));