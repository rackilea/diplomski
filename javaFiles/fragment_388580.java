public enum Direction
{
    SouthEast(1,1),
    NorthEast(1,-1);

    int _xPoint, _yPoint;

    Direction(int xPoint, int yPoint)
    {
        _xPoint = xPoint;
        _yPoint = yPoint;
    }

    public static Direction getDirectionByPoints(int xPoint, int yPoint)
    {
        for (Direction direction : Direction.values())
        {
            if(   Integer.signum(xPoint) == direction._xPoint 
               && Integer.signum(yPoint) == direction._yPoint )
            {
                return direction;
            }
        }
        throw new IllegalStateException("No suitable Direction found");
    }
}