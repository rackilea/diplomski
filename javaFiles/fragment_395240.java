interface Game<R, G extends Game<R, G>>
{
    void play(Player<R, G> player);
}

interface Player<R, G extends Game<R, G>>
{
    R takeTurn(G game);
}

abstract class AbstractGame<R, G extends AbstractGame<R, G>>
    implements Game<R, G>
{
    public final void play(final Player<R, G> player)
    {
        final R value;

        value = player.takeTurn(self());
        turnTaken(value);
    }

    protected abstract G self();

    protected abstract void turnTaken(R value);
}

public final class XGame extends AbstractGame<Integer, XGame>
{
   protected XGame self() {
      return this;
   }

   protected void turnTaken(Integer value) { }
}

public class XPlayer implements Player<Integer, XGame>
{
    @Override
    public Integer takeTurn(final XGame game)
    {
       return (42);
    }
}