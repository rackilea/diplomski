private class MoveValue {

    public double returnValue;
    public Move returnMove;

    public MoveValue() {
        returnValue = 0;
    }

    public MoveValue(double returnValue) {
        this.returnValue = returnValue;
    }

    public MoveValue(double returnValue, Move returnMove) {
        this.returnValue = returnValue;
        this.returnMove = returnMove;
    }

}


protected MoveValue minMax(double alpha, double beta, int maxDepth, MarbleType player) {       
    if (!canContinue()) {
        return new MoveValue();
    }        
    ArrayList<Move> moves = sortMoves(generateLegalMoves(player));
    Iterator<Move> movesIterator = moves.iterator();
    double value = 0;
    boolean isMaximizer = (player.equals(playerType)); 
    if (maxDepth == 0 || board.isGameOver()) {            
        value = evaluateBoard();            
        return new MoveValue(value);
    }
    MoveValue returnMove;
    MoveValue bestMove = null;
    if (isMaximizer) {           
        while (movesIterator.hasNext()) {
            Move currentMove = movesIterator.next();
            board.applyMove(currentMove);
            returnMove = minMax(alpha, beta, maxDepth - 1, player.opponent());
            board.undoLastMove();
            if ((bestMove == null) || (bestMove.returnValue < returnMove.returnValue)) {
                bestMove = returnMove;
                bestMove.returnMove = currentMove;
            }
            if (returnMove.returnValue > alpha) {
                alpha = returnMove.returnValue;
                bestMove = returnMove;
            }
            if (beta <= alpha) {
                bestMove.returnValue = beta;
                bestMove.returnMove = null;
                return bestMove; // pruning
            }
        }
        return bestMove;
    } else {
        while (movesIterator.hasNext()) {
            Move currentMove = movesIterator.next();
            board.applyMove(currentMove);
            returnMove = minMax(alpha, beta, maxDepth - 1, player.opponent());
            board.undoLastMove();
            if ((bestMove == null) || (bestMove.returnValue > returnMove.returnValue)) {
                bestMove = returnMove;
                bestMove.returnMove = currentMove;
            }
            if (returnMove.returnValue < beta) {
                beta = returnMove.returnValue;
                bestMove = returnMove;
            }
            if (beta <= alpha) {
                bestMove.returnValue = alpha;
                bestMove.returnMove = null;
                return bestMove; // pruning
            }
        }
        return bestMove;
    }   
}