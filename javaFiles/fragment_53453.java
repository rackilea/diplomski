public Grid ()
{
    final Color BACKGROUND = Color.LIGHT_GRAY;
    final Color[] colors = new Color[]
        {Color.BLACK, Color.BLACK, Color.BLUE, Color.BLUE};

    final int ROWS=10;
    final int COLS=10;

    setBackground(Color.BLACK);
    setLayout(new GridBagLayout());

    Label[][] label = new Label[ROWS][COLS];

    GridBagConstraints gc = new GridBagConstraints();
    gc.weightx = 1d;
    gc.weighty = 1d;
    gc.insets = new Insets(0, 0, 1, 1);
    gc.fill = GridBagConstraints.BOTH;

    // fill the whole panel with labels
    for( int r=0 ; r<ROWS ; r++) {
        for( int c=0 ; c<COLS ; c++) {
            Label l = new Label();
            l.setBackground(BACKGROUND);
            gc.gridx = r;
            gc.gridy = c;
            add(l, gc);
            label[r][c] = l;
        }
    }

    // now find random fields for the colors defined in BACKGROUND
    for(Color col : colors) {
        int r, c;
        do { // make sure to find unique fields
            r = (int)Math.floor(Math.random() * ROWS);
            c = (int)Math.floor(Math.random() * COLS);
        } while(!label[r][c].getBackground().equals(BACKGROUND));
        label[r][c].setBackground(col);
    }
}