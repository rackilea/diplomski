Board(Object[][] GameBoard, ArrayList<Object> BlackBoardObjects, ArrayList <Object> WhiteBoardObjects){
    this.GameBoard = GameBoard;
    this.BlackBoardObjects = BlackBoardObjects;
    this.WhiteBoardObjects = WhiteBoardObjects;
}

public Board getCopy(){
    for(int i = 0; i < GameBoard.length; i++){
        for(int j = 0; j < GameBoard[0].length; j++){
            GameBoardCopy[i][j] = GameBoard[i][j].getCopy();
        }
    }
    ArrayList<Move> BlackBoardObjectsCopy = new ArrayList<Move>(BlackBoardObjects);
    ArrayList <Move> WhiteBoardObjectsCopy = new ArrayList<Move>(WhiteBoardObjects);
    return new Board(GameBoard, BlackBoardObjectsCopy, WhiteBoardObjectsCopy);
}