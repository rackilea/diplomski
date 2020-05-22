public int MinimaxIterativeDeepeningAlphaBeta(GameState currentBoard, int currentDepth, int maxPlayer, boolean isMax, boolean isMin, int maxDepth, int alpha, int beta,long start_time,boolean exceeded_time) {
    // code omitted for clarity

            for (int i = 1; i < 7; i++) {

                //check to see if move is possible or not
                if (currentBoard.moveIsPossible(i)) {

                    //copy the current board in each iteration
                    GameState newBoard = currentBoard.clone();
                    newBoard.makeMove(i);

                    // code omitted for clarity
                }
            }

    // code omitted for clarity
}