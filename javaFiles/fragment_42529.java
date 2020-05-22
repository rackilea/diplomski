...
private int[][] board;
...
public Eightqueens (int size)
{
    size = 8; // remove this
    ...
}

public int[][] getBoard() 
{
    return board;
}

public static void main(String[] args) 
{
    Eightqueens equeens = new Eightqueens (8); // create an instance
    JOptionPane.showMessageDialog(null,equeens.getBoard()); // use accessor to get
                                                            // board
}