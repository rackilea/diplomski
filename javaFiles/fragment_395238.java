abstract class AbstractGame<R, P extends Player<R, P, AbstractGame<R, P>>>
    implements Game<R, AbstractGame<R, P>, P>
{
    public final void play(final P player)
    {
        final R value;

        value = player.takeTurn(this);
        turnTaken(value);
    }

    protected abstract void turnTaken(R value);
}