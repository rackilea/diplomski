public class Board
{
    // This is what you're passing around now; Board hides it.
    // Square is the abstraction of a position on the Board
    private Square[][] grid;

    public Board(int nRows, int nCols)        
    {
       this.grid = new Square[nRows][];
       for (int i = 0; i < this.grid[i].length; ++i)
       {
           this.grid[i] = new Square[nCols];
       }
    }

    // Now add methods for adding Pieces to the Board, rules for moving them, etc.
}