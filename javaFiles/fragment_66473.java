static void solve(int row, int col, int [][]grid){

       if (row>=grid.length){

           System.out.println("solution found");
           printSolvedGrid(grid);
           System.exit(0);

       }

       if( grid[row][col] != 0 ){
            next( row, col, grid ) ;
       }

       else {
         // Find a valid number for the empty cell
         for( int num = 1; num < 10; num++ )
         {
            if( checkRow(row,num,grid) && checkCol(col,num,grid) && checkBox(row,col,num,grid) )
            {
               grid[row][col] = num ;
               moveCounter++;
               System.out.println("current move count is " + moveCounter);
               printSolvedGrid(grid);
               next( row, col, grid );

            }
         }

         grid[row][col] = 0 ;
       }

    }