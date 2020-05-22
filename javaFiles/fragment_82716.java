public void TicTacToe() // needs to be public FranzTicTacToe()
    {
        c = getContentPane();
        gameBoard = new JButton[3][3];
        imageo = new ImageIcon("C:\\Users\\hftri\\Downloads\\tic.jpg");
        imagex = new ImageIcon("C:\\Users\\hftri\\Downloads\\tac.jpg");
        isGameOver = false;
        c.setLayout(new GridLayout(3,3));
        setTitle("Harambe");
        setBounds(250, 250, 300, 300);
    for(int column=0; column < 3; column++)
    {
        for(int row=0; row < 3; row++)
        {
            gameBoard[column][row] = new JButton();
            c.add(gameBoard[column][row]);
            gameBoard[column][row].addActionListener(this);
        }
    }
}