for(int i = 0; i < board.length; i++) {
        //Always check for nulls, unless you're 100% certain of the data
        if (board[i] != null) {   
          for(int j = 0; j < board[i][j].length; j++) {
              //Here I get the error "incomparable types: char and char[]
              if('\u0000' == board[i][j]) {  
                      System.out.println("Game unfinished.");                  
              }
          }
 }