for(int row = 0; row < maze.length; row++)
     {
         for(int col = 0; col < maze[0].length;col++){
             if(maze[row][col] == 's'){
                 System.out.println("x :" + row + " y : " + col);
             }
         }
     }