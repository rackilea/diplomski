class SudokuBoard
{
    public void setBoardFromArray( int[][] otherBoard )
    {
        for( int i = 0; i < otherBoard.length; i++ )
        {
            // Clone the arrays that actually have the data
            this.board[i] = otherBoard[i].clone();
        }
    }
}