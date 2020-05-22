Looks like you should have this method like this 

 public void printGrid(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < columns; ++j){
                System.out.print(grid[i][j] + "      ");
            }
               System.out.println("|");
        }