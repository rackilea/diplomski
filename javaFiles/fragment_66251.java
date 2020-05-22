public Parent createBoard() {

    GridPane gameBoard = new GridPane();
    gameBoard.setPrefSize(755, 755);

    for (int i = 0; i < BOARD_SIZE; i++) {
        for (int j = 0; j < BOARD_SIZE; j++) {

            Rectangle tile = new Rectangle(50, 50);
            tile.setFill(Color.BURLYWOOD);
            tile.setStroke(Color.BLACK);

            Text text = new Text();
            text.setFont(Font.font(40));
            gameBoard.add(new StackPane(tile, text), j, i);

            //GridPane.setRowIndex(tile, i);
            //GridPane.setColumnIndex(tile, j);   
            //gameBoard.getChildren().addAll(tile, text);
            tile.setOnMouseClicked(event -> drawMove(text));
        }
    }
    return gameBoard;
}