public AbacusPanel(int nc, int nr)
    {
            numCols = nc;
            numRows = nr;
            addMouseListener(this);
            this.myAbacus = new AbacusModel(numCols,numRows);
    }