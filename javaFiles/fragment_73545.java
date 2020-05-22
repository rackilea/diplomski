/**
 * This simulation assumes dog movement is discrete relative to grid cells
 * i.e. its either in one of these cells at a time, overlapping two cells in not allowed!!
 * **/
public class DogMovementSimulation 
{
    int onBoard[][] = null;
    int dogPosX = 0;
    int dogPosY = 0;
    int dogPrevPosX = 0;
    int dogPrevPosY = 0;

    int directionOfMovement = 0;
    int stepsCount = 0;

    DogMovementSimulation()
    {
        onBoard = new int[8][8];
        //initialize each position in onBoard to -1 ,implying dog has not been placed yet, not even once!!
        for( int i = 0 ; i < 8 ; i++ )
        {
            for( int j = 0 ; j < 8 ; j++ )
            {
                onBoard[i][j] = -1;//implying dog has not been placed yet, not even once!!
            }
        }

        //place dog in random cell
        dogPosX = (int)Math.round(Math.random()*7);//generating random number between 0 and 7, since index is from 0 to 7 as there are 8 cell!!
        dogPosY = (int)Math.round(Math.random()*7);
        //assigning 1 to onBoard at index dogPosX,dogPosY to indicate dog has been placed there
        onBoard[dogPosX][dogPosY] = 1;
    }

    /*this function returns false if any cell has -1,else true
     * cause when all cells have been traversed , each cell have non negative value,either 0 or 1 
     *  */
    public boolean areAllCellsTraversed()
    {
        boolean result = true;

        for( int i = 0 ; i < 8 ; i++ )
        {
            for( int j = 0 ; j < 8 ; j++ )
            {
                if( onBoard[i][j] == -1 )//implying this cell not traversed yet,i.e dog not placed in this cell yet!!
                {
                    result = false;
                }
            }
        }
        return result;
    }

    public void simulate()
    {
        //loop while all cells have been not traversed
        while( !areAllCellsTraversed() )
        {
            directionOfMovement = (int)Math.round(Math.random()*3);//generating random number between 0 and 3
            switch( directionOfMovement )
            {
            case 0://move left-to-right
                dogPosX += 1;
                if( dogPosX >= 7 ) dogPosX = 0; //since largest array index is 1 less than its size, we compare with 7 instead of 8                 
                break;

            case 1://move right-to-left
                dogPosX -= 1;
                if( dogPosX <= 0 ) dogPosX = 7;                 
                break;

            case 2://move top-to-bottom
                dogPosY += 1;
                if( dogPosY >= 7 ) dogPosY = 0;                 
                break;

            case 3://move bottom-to-top
                dogPosY -= 1;
                if( dogPosY <= 0 ) dogPosY = 7;                 
                break;
            }

            //assign 0 to previous position, meaning dog is no longer there
            onBoard[dogPrevPosX][dogPrevPosY] = 0;
            //assign 1 to new position , meaning dog is here
            onBoard[dogPosX][dogPosY] = 1;

            stepsCount++;
            dogPrevPosX = dogPosX;
            dogPrevPosY = dogPosY;                  
        }   
        //once all cells have been traversed , print result!!
        printSteps();
    }   

    /*prints the total number of step taken to traverse all cells*/
    public void printSteps()
    {
        System.out.println("Total steps taken by dog to traverse all cell = "+stepsCount);
    }

    public static void main(String[] args)
    {
        DogMovementSimulation dms = new DogMovementSimulation();
        dms.simulate();     
    }
}