public void printTable(int result[], int N)
{
    // Clear the board.
    board = new int[8][8];

    for(int s=0;s<result.length;s++){
        for (int u=0;u<result.length;u++)
        {
            board[s][result[s]]=1;
        }  

        for(int j=0;j<result.length;j++){

            if(board[s][j]==1)
                System.out.print("Q");
            else
                System.out.print("*" );
        }

        System.out.println();//"\n");
    }

    // Line at the end to separate the different boards from one another.
    System.out.println("---------------------");
}