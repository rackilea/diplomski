class Piece {
   private String color; // instance field


   /**
       Takes a piece instance as an argument, and operates on that.
    */
   private static void changeToWhite(Piece piece) {
      piece.setColor('white'); // assume setColor exists
   }

}