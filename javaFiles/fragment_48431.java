/* class GameObject */
public boolean contains(int x, int y)
{  
    //Your use of parentheses here was really confusing!  
    return mPosition[0] - mScale[0] < x && x < mPosition[0] + mScale[0]
        && mPosition[1] - mScale[1] < y && y < mPosition[1] + mScale[1];

    /* alternatively:
    return Math.abs(x - mPosition[0]) < mScale[0]
        && Math.abs(y - mPosition[1]) < mScale[1];
    */
}

/* class Manager */
public void onTouchEvent( Event event )
{
    for( GameObject o : mGameObjectList )
    {
        if(o.contains(event.getX(), event.getY()))
        {
            o.onTouchEvent(event);
        }
    }
}