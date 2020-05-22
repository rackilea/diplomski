public static void click(int X, int Y){
    System.out.println("X. " + X + " Y. " + Y);

    //Look for every block in the matrix
    for ( int i = 0; i<Screen.room.block.length; i++ ) {
      for ( int j = 0; j<Screen.room.block[0].length; j++ ) {
         if(Screen.room.block[i][j].airID == Value.tower){
            //Check if we hit within the block's bounds
            if ( X >= i && X <= i+blockWidth &&
                 Y >= j && Y <= j+blockHeight  )
             System.out.println("Tower clicked");
             return;
         }
      }
    }
}