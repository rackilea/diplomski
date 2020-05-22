public void update()
{
    if (xToMove > 0)
    {
        xToMove--;
        x++;
    }
    if (xToMove < 0)
    {
        xToMove++;
        x--;
    }
    if (yToMove > 0)
    {
        yToMove--;
        y++;
    }
    if (yToMove < 0)
    {
        yToMove++;
        y--;
    }
}