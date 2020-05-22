public class TicTacToe
{
    char[][] ticTacToe = 
    {{'X',' ','O'},
     {'O','X','O'},
     {'X',' ','X'},};

    private Character winner = null;

    public Character getWinner()
    {
        return this.winner;
    }

    public boolean isSolved()
    {
        this.checkSolved();
        return this.winner != null;
    }

    private void checkSolved()
    {
        for(int i = 0; i < ticTacToe.length; i++)
        {
            Character win = checkRow(i);
            if(win != null || (win = checkColumn(i)) != null)
            {
                this.winner = win;
                return;
            }
        }
        //Check diagonal top left to bottom right
        if(this.ticTacToe[0][0] != ' ')
        {
            if(this.ticTacToe[0][0] == this.ticTacToe[1][1] &&
               this.ticTacToe[1][1] == this.ticTacToe[2][2])
            {
                this.winner = this.ticTacToe[0][0];
            }
        }
        //Check diagonal top right to bottom left
        else if(this.ticTacToe[0][2] != ' ')
        {
            if(this.ticTacToe[0][2] == this.ticTacToe[1][1] &&
               this.ticTacToe[1][1] == this.ticTacToe[2][0])
            {
                this.winner = this.ticTacToe[0][2];
            }
        }
    }

    private Character checkRow(int row)
    {
        if(this.ticTacToe[row][0] == ' ')
        {
            return null;
        }
        if(this.ticTacToe[row][0] == this.ticTacToe[row][1] &&
           this.ticTacToe[row][1] == this.ticTacToe[row][2])
        {
            return this.ticTacToe[row][0];
        }
        return null;
    }

    private Character checkColumn(int column)
    {
        if(this.ticTacToe[0][column] == ' ')
        {
            return null;
        }
        if(this.ticTacToe[0][column] == this.ticTacToe[1][column] &&
           this.ticTacToe[1][column] == this.ticTacToe[2][column])
        {
            return this.ticTacToe[column][0];
        }
        return null;
    }

    public static void main(String[] args)
    {
        TicTacToe ttt = new TicTacToe();
        if(ttt.isSolved())
        {
            System.out.println(ttt.getWinner());  // X
        }
    }
}