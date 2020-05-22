class SudokuBoard
{
    public void setBoard( SudokuBoard other )
    {
        for( int i = 0; i < 81; i++ )
        {
            this.positionListonX[i] = other.positionListonX[i];
            this.positionListonY[i] = other.positionListonY[i];
        }
        // Copy any other properties
    }
}