public class Point2 extends Point1    
{
    private int _z;
    public Point2(Point2 other)
    {
        super(other);
        this._z = other._z;
    }
}