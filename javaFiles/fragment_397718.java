this.setLayout(new MigLayout("ins 0, wrap " + COLS + ", gap 1", "grow", "grow"));


        for (int row = 0; row < ROWS; row++)
            for (int col = 0; col < COLS; col++)
                this.add(new Location(row, col), "grow");