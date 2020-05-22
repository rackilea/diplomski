protected static final float MIN_X = 10;
protected static final float MAX_X = 590;

public void moveLeft()
{
    if (x > MIN_X)
    {
        x -= 5;
    }
}

public void moveRight()
{
    if (x < MAX_X)
    {
        x += 5;
    }
}