TetrisPiece piece;

switch(rand){
  //I
  case 1: {
   piece = new PieceI();
   break;
  }
  //T
  case 2: {
   piece = new PieceT();
   break;
  }
  etc...
  default:
   break;
}