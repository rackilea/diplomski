if (currentBoard.getWinner() > -1) {
    return bestMove;
}

for (int i = 1; currentBoard.getWinner() == -1; i++) //for (int i = 1; elapsed_time < timeLimit ; i++)
{
    value = MinimaxIterativeDeepeningAlphaBeta(currentBoard, 1, maxPlayer, isMax, isMin, i, alpha, beta, start_time, time_exceeded);
    // code omitted for clarity
    if (elapsed_time >= 4999) {
        // code omitted for clarity
        break;
    }
}