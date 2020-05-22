class TheObject
{
    private final java.util.List<Point> points;

    public TheObject(List<Point> points)
    {
        this.points = points;
    }

    @Override
    public int hashCode()
    {
        int hash = 17;int tmp = 0;
        for (Point p : points)
        {
            tmp = (hash + p.hashCode());
            hash = (tmp << 5) - tmp;
        }
        return hash;
    }
}