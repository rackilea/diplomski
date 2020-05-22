public static void dropBall(){
    for (i =Settings.row-1;i>=0;i--){
       for (j =Settings.col-1;j>=0 ; j--){
           if (Settings.grid[i+1][j]==666){ 
              //checking if the space below has the 666 ID (666 ID equals to blank)                   
               Settings.grid[i+1][j]=Settings.grid[i][j]; //Deleting the current blank                 
               Settings.grid[i][j] = 666;
           }
       }
    }
 }