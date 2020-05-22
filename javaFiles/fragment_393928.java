public class Player
{
    private int x, y, collectedDots;

    int initialX = 15;
    int initialY = 20;

    public Player()
    {
        x = initialX;
        y = initialY;

        collectedDots = 0;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

}