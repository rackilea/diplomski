float minimax_max(GameState g)
{
    if (g is terminal or max depth reached)
        return eval(g);

    float bestVal = -inf;
    bestMove = null;

    moves = g->getLegalMoves();
    for (m : moves)
    {
        ApplyMove(m);
        if (g->nextPlayer == maxPlayer)
            nextVal = minimax_max(g);
        else
            nextVal = minimax_min(g);
        if (nextVal > bestVal)
        {
            bestVal = nextVal;
            bestMove = m;
        }
        UndoMove(m);
    }

    return bestVal;
}