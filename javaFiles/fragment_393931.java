public class Player
{
    private int x, y, collectedDots;

    public Player(int initialX, int initialY)
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

    public void setX(int newX)
    {
        x = newX;
    }

    public void setY(int newY)
    {
        y = newY;
    }
}