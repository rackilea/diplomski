private int x;

public int getX()
{
    return x;
}

public void setX(int anX)
{
    x = anX;
    updateLabel("This is x:" + anX)
}

public void process()
{
    while(true)
    {
        int anX = getX();
        setX(anX + 1);
    }
}