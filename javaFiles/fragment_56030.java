public void fillBoard(Board board) {
    // get a randomly picked shape from a defines set
    // for example { |  L  T  ■ }
    Shape shape = getRandomShape();

    // While there is enough free spaces in your board for this shape
    while(board.hasPlaceForShape(shape) {
        //Choose the number to fill this shape with
        int number = getRandomNumber();
        // find and fill the next free space in your board with your shape and numberin
        board.findAndFillNextFreeSpaceForShape(shape, number);
        //pick a new shape to continue
        shape = getRandomShape();
   }

   //fill the rest of your board with random number
   List<Tile> emptyTiles = board.getEmptyTiles();
   for(Tile t : emptyTiles) {
       t.setNumber(getRandomNumber);
   }
}