public class XGame
    extends AbstractGame<Integer, XPlayer> //compile error on XPlayer
{

    protected void turnTaken(Integer value) { }
}

public class XPlayer
    implements Player<Integer, XPlayer, XGame> //compile error on XGame
{
    @Override
    public Integer takeTurn(final XGame game)
    {
        return (42);
    }
}