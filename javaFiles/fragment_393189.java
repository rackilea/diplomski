public boolean isAbove (Point other)
{
    return _y > other._y;       
}

public boolean isUnder (Point other)
{
    return other.isAbove(this);
}

public boolean isLeft (Point other)
{
    return _x < other._x;
}

public boolean isRight (Point other)
{
    return other.isLeft(this);
}