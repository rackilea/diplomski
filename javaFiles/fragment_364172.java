if (xToMove > 0)
{
    xToMove -= speed;
    x += speed;
    if (xToMove <= 0)
    {
        //Set these guys to nice even numbers to prevent problems
        xToMove = 0;
        x = (float) Math.round(x);
    }
}