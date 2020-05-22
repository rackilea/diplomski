public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>()
{
    @Override
    public int compare(Point p0, Point p1)
    {
        double s0 = slopeTo(p0);
        double s1 = slopeTo(p1);
        return Double.compare(s0, s1);
    }
};