public Maze() {
    JPanel panel = new JPanel();
    getContentPane().add(panel);

    int row = MazeCreator.r;
    int col = MazeCreator.c;

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 500, 500);
    panel.setLayout(new GridLayout(row, col));

    JLabel[][] grid= new JLabel[row][col];
    for (int i = 0; i < row; i++){
        for (int j = 0; j < col; j++){
            grid[i][j] = new JLabel();
            grid[i][j].setBorder(new LineBorder(Color.BLACK));
            //grid[i][j].setBackground(Color.black);
            grid[i][j].setOpaque(true);
            panel.add(grid[i][j]);
        }
    }
    grid[0][0].setBackground(Color.red);
}