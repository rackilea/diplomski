interface Player<R, P extends Player<R, P, G>, G extends Game<R, G, P>>
{
    R takeTurn(G game);
}

interface Game<R, G extends Game<R, G, P>, P extends Player<R, P, G>>
{
    void play(P player);
}